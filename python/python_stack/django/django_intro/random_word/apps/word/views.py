from django.shortcuts import render, redirect
from django.utils.crypto import get_random_string 


def random(request):
    if "counter" in request.session:
        request.session["counter"] += 1
    else: 
        request.session["counter"] = 1
    
    context = {
        "random_word" : get_random_string () 
    }

    return render (request, "word/index.html", context)

def reset (request):
    request.session["counter"] = 0

    return redirect ("/")
