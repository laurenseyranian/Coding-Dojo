from __future__ import unicode_literals
from django.db import models
from django.contrib.auth.models import *
import re, bcrypt

class UserManager (models.Manager):
    def registration_validator(self, postData):
        errors = {}
        if len(postData["first_name"]) < 2:
            errors["first_name"] = "First name should be at least 2 characters."
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Last name should be at least 2 characters."


        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):
            errors["email"] = "Invalid email address."
        user = User.objects.filter(email = postData ["email"])
        if len(user)>0:
            errors["email_exist"] = "Email already exists."

        PASSWORD_REGEX = re.compile(r"^(?=.*[0-9])")
        if not PASSWORD_REGEX.match(postData["password"]):
            errors["validemail"] = "Password must contain at least 1 number."
        if len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters."
        if postData["password"] != postData["confirm_password"]:
            errors["confirm_password"]= "Passwords do not match."

        return errors


    def login_validator(self, postData):
        errors = {}
        user = User.objects.filter(email = postData["email"])
        if len(postData ["email"]) < 1:
            errors["email"] = "Please enter a valid email."
        elif not user:
            errors["email"] = "Email does not exist."

        else:
            logged_user = user[0]
            if len(postData ["password"]) < 1:
                errors["password"] = "Please enter a valid password."
    
            elif not bcrypt.checkpw(postData["password"].encode(), logged_user.password.encode()):
                errors["password"] = "Invalid password."
        
        return errors

    def successful_login_validation (self, postData):
        errors = {}
        errors["success"] = "You have successfully logged in."
        return errors


class User (models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    #one to many - user = related to "trips"
    objects = UserManager ()

class TripManager (models.Manager):
    def trip_validator(self, postData):
        errors = {}
        if len(postData["destination"]) < 3:
            errors["destination"] = "A trip destination must consist of at least 3 characters"
        if len(postData["plan"]) < 0:
            errors["plan"] = "A plan must be provided"
        return errors


class Trip(models.Model):
    destination = models.CharField(max_length=255)
    start_date = models.DateTimeField ()
    end_date = models.DateTimeField ()
    plan = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    user = models.ForeignKey (User, related_name = "trips")
    objects = TripManager ()
    

