from django.shortcuts import render, redirect
from django.contrib import messages

from apps.tv_shows_app.models import Show

def add_show(request):
    if request.method == "GET":
        return render (request, "tv_shows_app/add_show.html")
    
    else:
        tv_show = Show.objects.create(title = request.POST ["title"], 
        network = request.POST ["network"], 
        release_date = request.POST ["release_date"], 
        description = request.POST["description"])
        return redirect ("/shows/" + str(tv_show.id))

def all_shows(request):
    tv_show = Show.objects.all()
    context = {
        "all_shows" : tv_show
    }
    return render(request, "tv_shows_app/view_all_shows.html", context)

def display_show(request, id):
    tv_show = Show.objects.get(id=id)
    context = {
        "tv_show" : tv_show
    }
    return render (request, "tv_shows_app/view_show.html", context)

def edit_show(request, id):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect("/shows/" + str(tv_show.id) + "/edit")

    elif request.method=="GET":
        context = {
            "tv_show" : Show.objects.get(id=id)
        }
        return render (request, "tv_shows_app/edit_show.html", context)
    else: 
        tv_show = Show.objects.get(id=id)
        tv_show.title = request.POST["title"]
        tv_show.network = request.POST["network"]
        tv_show.description = request.POST["description"]
        tv_show.release_date = request.POST ["release_date"]
        tv_show.save()
        return redirect ("/shows/" + str(tv_show.id))

def delete_show(request, id):
    tv_show = Show.objects.get(id=id)
    tv_show.delete()
    return redirect ("/shows")


