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
            return redirect("/dashboard")

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
            return redirect("/dashboard")

def logout (request):
    request.session.clear()
    return redirect ("/")

# ///////////////////////////////////////////////////////////////////////////////////////

def dashboard (request):
    logged_user = User.objects.get(id=request.session["id"])
    all_jobs = Job.objects.all

    context = {
        "logged_user" : logged_user,
        "all_jobs" : all_jobs
    }

    errors = User.objects.successful_login_validation(request.POST)
    for key, value in errors.items():
        messages.success(request, value)

        return render (request, "first_app/dashboard.html", context)

def add_job (request):
    context = {
        "logged_user" : User.objects.get(id=request.session["id"]),
    }
    return render (request, "first_app/add_job.html", context)

def create_job (request):
    if request.method == "POST":
        errors = Job.objects.job_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect("/jobs/new")
    Job.objects.create(
        title = request.POST["title"],
        description = request.POST["description"],
        location = request.POST["location"],
        user=User.objects.get(id=request.session["id"])
    )
    
    return redirect ("/dashboard")

def show_job (request,id):
    user = User.objects.get(id=request.session["id"])
    jobs = Job.objects.get(id=id)
    context = {
        "jobs" : jobs,
        "user" : user
    }
    return render (request, "first_app/show_job.html", context)

def edit_job (request,id):
    logged_user = User.objects.get(id=request.session["id"])
    job = Job.objects.get(id=id)
    context = {
        "job" : job,
        "logged_user" :logged_user
    }
    return render (request, "first_app/edit_job.html", context)


def update_job (request):
    if request.method == "POST":
        errors = Job.objects.job_validator(request.POST)
        if errors:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect (f"/jobs/{request.POST['job_id']}/edit")
        if len(errors) > 0:
            return redirect("/")
        else:
            edit_job = Job.objects.get(id=request.POST["job_id"])
            edit_job.title = request.POST["title"]
            edit_job.description = request.POST["description"]
            edit_job.location = request.POST["location"]
            edit_job.save()
        return redirect ("/dashboard")

def delete_job (request, id):
    delete = Job.objects.get(id=id)
    delete.delete()
    return redirect ("/dashboard")



