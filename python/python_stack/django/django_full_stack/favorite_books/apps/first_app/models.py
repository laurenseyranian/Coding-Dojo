from __future__ import unicode_literals
from django.db import models
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
    #one to many - books_uploaded = related to "uploaded books"
    #many to many - favorite books = related to "users who favorited"
    objects = UserManager ()

class BookManager (models.Manager):
    def book_validator(self, postData):
        errors = {}
        if len(postData["title"]) < 1:
            errors["title"] = "Please enter a title"
        if len(postData["description"]) < 5:
            errors["description"] = "Description must be at least 5 characters long"
        return errors


class Book (models.Model):
    title = models.CharField(max_length=255)
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    uploaded_by = models.ForeignKey (User, related_name = "books_uploaded")
    users_who_favorited = models.ManyToManyField(User, related_name= "favorite_books")
    objects = BookManager ()

