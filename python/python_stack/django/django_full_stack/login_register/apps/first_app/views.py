from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
import bcrypt

def index(request):
    return render(request, "first_app/index.html")

def register_user(request):
    if request.method == "POST":
        errors = User.objects.registration_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect("/")
        
        else:
            password = request.POST["password"]
            pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt())
            
            user = User.objects.create(
                first_name = request.POST["first_name"], 
                last_name = request.POST["last_name"], 
                email = request.POST["email"], 
                password = pw_hash
            )

            request.session['id'] = user.id
            return redirect("/success")

def login_user(request):
    if request.method == "POST":
        errors = User.objects.login_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect("/")

        else:
            user = User.objects.get(email = request.POST["email"])
            request.session["id"] = user.id
            return redirect("/success")

def success (request):
    user = User.objects.get(id=request.session["id"])
    context = {
        "first_name" : user.first_name
    }

    errors = User.objects.successful_login_validation(request.POST)
    for key, value in errors.items():
        messages.error(request, value)

        return render (request, "first_app/success.html", context)

def logout (request):
    request.session.clear()
    return redirect ("/")

