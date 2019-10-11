from django.shortcuts import render, redirect

import random

from datetime import datetime

def index(request):
    if "gold" not in request.session:
        request.session["gold"] = 0
        request.session["activity"] = []
    else:
        request.session["gold"] += 1
    
    context = {
        "wallet": request.session["gold"],
        "activity": request.session["activity"],
    }
    return render(request, "ninja_gold_app/index.html", context)

def process(request):
    if request.method == "POST":

        if request.POST["location"] == "farm":
            farm_gold = random.randint(10,20)
            request.session['gold'] += farm_gold
            request.session['activity'].append('You are earned ' + str(farm_gold) + ' golds from the ' + request.POST['location'] + ' ' + '(' + str(datetime.now().strftime("%m-%d-%Y %H:%M.%S")) + ')')


        if request.POST["location"] == "cave":
            cave_gold = random.randint(5,10)
            request.session['gold'] += cave_gold
            request.session['activity'].append('You are earned ' + str(cave_gold) + ' golds from the ' + request.POST['location'] + ' ' + '(' + str(datetime.now().strftime("%m-%d-%Y %H:%M.%S")) + ')')
 
        if request.POST["location"] == "house":
            house_gold = random.randint(2,5)
            request.session['gold'] += house_gold
            request.session['activity'].append('You are earned ' + str(house_gold) + ' golds from the ' + request.POST['location'] + ' ' + '(' + str(datetime.now().strftime("%m-%d-%Y %H:%M.%S")) + ')')
 
        if request.POST["location"] == "casino":
            casino_gold = random.randint(-50,50)
            request.session['gold'] += casino_gold
            if casino_gold >=0:
                request.session['activity'].append('You are earned ' + str(casino_gold) + ' golds from the ' + request.POST['location'] + ' ' + '(' + str(datetime.now().strftime("%m-%d-%Y %H:%M.%S")) + ')')
            else:
                request.session['activity'].append('You lost ' + str(casino_gold) + ' gold from the ' + request.POST['location'] + ' ' + '(' + str(datetime.now().strftime("%m-%d-%Y %H:%M.%S")) + ')')

    return redirect("/")

def reset (request):
    request.session.clear ()
    return redirect("/")