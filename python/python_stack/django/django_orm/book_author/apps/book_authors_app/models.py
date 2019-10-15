from django.db import models

class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField ()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __repr__(self):
        return f"Title: {self.title}, Description: {self.desc}"

class Author(models.Model):
    books = models.ManyToManyField(Book, related_name="authors")
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    notes = models.TextField ()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __repr__(self):
        return f"Author: {self.first_name} {self.last_name}"
