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

def dashboard (request):
    logged_user = User.objects.get(id=request.session["id"])
    all_trips = Trip.objects.all()

    context = {
        "logged_user" : logged_user,
        "all_trips" : all_trips
    }

    errors = User.objects.successful_login_validation(request.POST)
    for key, value in errors.items():
        messages.success(request, value)

        return render (request, "first_app/dashboard.html", context)

def add_trip (request):
    context = {
        "logged_user" : User.objects.get(id=request.session["id"]),
    }
    return render (request, "first_app/add_trip.html", context)

def create_trip (request):
    if request.method == "POST":
        errors = Trip.objects.trip_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect("/trips/new")
    Trip.objects.create(
        destination = request.POST["destination"],
        start_date = request.POST["start_date"],
        end_date = request.POST["end_date"],
        plan = request.POST["plan"], 
        user=User.objects.get(id=request.session["id"])
    )
    return redirect ("/dashboard")

def show_trip (request,id):
    user = User.objects.get(id=request.session["id"])
    trips = Trip.objects.get(id=id)
    context = {
        "trips" : trips,
        "user" : user
    }
    return render (request, "first_app/show_trip.html", context)

def edit_trip (request,id):
    logged_user = User.objects.get(id=request.session["id"])
    trip = Trip.objects.get(id=id)
    context = {
        "trip" : trip,
        "logged_user" :logged_user
    }
    return render (request, "first_app/edit_trip.html", context)


def update_trip (request):
    if request.method == "POST":
        errors = Trip.objects.trip_validator(request.POST)
        if errors:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect (f"/trips/{request.POST['trips_id']}/edit")
        if len(errors) > 0:
            return redirect("/")
        else:
            edit_trip = Trip.objects.get(id=request.POST["trips_id"])
            edit_trip.destination = request.POST["destination"]
            edit_trip.start_date = request.POST["start_date"]
            edit_trip.end_date = request.POST["end_date"]
            edit_trip.plan = request.POST["plan"]
            edit_trip.save()
        return redirect ("/dashboard")

def delete_trip (request, id):
    delete = Trip.objects.get(id=id)
    delete.delete()
    return redirect ("/dashboard")


