from django.shortcuts import render, HttpResponse
def index(request):
    return HttpResponse("Practicing Shell With Django")