from django.shortcuts import render, HttpResponse

from time import strftime, gmtime

def index(request):
    context = {
        "time": strftime("%B %-m, %Y %I:%M:%S %p", gmtime())
    }
    return render(request,'time_display_app/index.html', context)

def time_display(request):
    return rendirect ("/")