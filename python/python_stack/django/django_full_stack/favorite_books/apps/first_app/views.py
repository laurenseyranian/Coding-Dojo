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
    all_books = Book.objects.all()
    context = {
        "user" : user,
        "all_books" : all_books
    }

    errors = User.objects.successful_login_validation(request.POST)
    for key, value in errors.items():
        messages.success(request, value)

        return render (request, "first_app/success.html", context)

def logout (request):
    request.session.clear()
    return redirect ("/")



def add_book(request):
    if request.method == "POST":
        errors = Book.objects.book_validator(request.POST)
        for key, value in errors.items():
            messages.error(request, value)
            return redirect("/success")
        if len(errors) > 0:
            return redirect("/")

        else: 
            this_added = User.objects.get(id=request.session["id"])
            new_book = Book.objects.create(
                title = request.POST["title"],
                description = request.POST["description"],
                uploaded_by = this_added 
            )
            new_book.users_who_favorited.add(this_added)
            new_book.save()
        return redirect("/success")

def view_book(request, id):
    user = User.objects.get(id=request.session["id"])
    context = {
        "user" : user,
        "this_book" : Book.objects.get(id=id)
    }

    return render (request, "first_app/view_book.html", context)

def edit_book (request):
    edit_book = Book.objects.get(id=request.POST["book_id"])
    edit_book.title = request.POST["title"]
    edit_book.description = request.POST["description"]
    edit_book.save()
    return redirect ("/success")

def delete (request, id):
    delete = Book.objects.get(id=id)
    delete.delete()
    return redirect ("/success")

def book_details (request, id):
    user = User.objects.get(id=request.session["id"])
    book = Book.objects.get(id=id)
    context = {
        "this_book" : Book.objects.get(id=id)
    }

    if user.id == book.uploaded_by.id:
        return render (request, "first_app/view_book.html", context)
    
    else: 
        return render (request, "first_app/book_details.html", context)




