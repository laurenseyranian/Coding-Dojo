from django.shortcuts import render, redirect

from apps.book_authors_app.models import Book, Author

# book home page
def add_book(request):
    context = {
        "all_books": Book.objects.all()
    }
    return render (request, "book_authors_app/add_book.html", context)

# adds new book to the book home page
def add_new_book (request):
    Book.objects.create(title = request.POST ["title"], desc = request.POST ["description"])
    return redirect ("/")

# click the view button and view the book information
def view_book_info (request, book_id): 
    book = Book.objects.get(id=book_id)
    this_book_authors = Book.objects.get(id=book_id).authors.all()
    all_authors = Author.objects.all()
    other_authors = [author for author in all_authors if author not in this_book_authors]
    context = {
        "book": book,
        "all_authors": other_authors,
    }
    return render (request, "book_authors_app/view_book.html", context)

def add_author_to_book (request, book_id):
    author_id = request.POST['author_id']
    Book.objects.get(id=book_id).authors.add(Author.objects.get(id=author_id))
    return redirect(f"/books/{book_id}")



# author home page
def add_author(request):
    context = {
        "all_authors": Author.objects.all()
    }
    return render (request, "book_authors_app/add_author.html", context)

# adds new author to the author home page
def add_new_author (request):
    Author.objects.create(first_name = request.POST ["first_name"], last_name = request.POST ["last_name"], notes = request.POST ["notes"])
    return redirect ("/")

# click the view button and view the author information
def view_author_info (request, author_id): 
    author = Author.objects.get(id=author_id)
    this_author_books = Author.objects.get(id=author_id).books.all()
    all_books = Book.objects.all()
    other_books = [book for book in all_books if book not in this_author_books]
    context = {
        "author": author,
        "all_books": other_books,
    }
    return render (request, "book_authors_app/view_author.html", context)

def add_book_to_author (request, author_id):
    book_id = request.POST['book_id']
    Author.objects.get(id=author_id).books.add(Book.objects.get(id=book_id))
    return redirect(f"/authors/{author_id}")


