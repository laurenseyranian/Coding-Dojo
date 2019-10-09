from django.shortcuts import render, redirect

def index(request):
    if "gold" not in request.session:
        request.session["gold"] = 0

    else:
        request.session["gold"] += 1
    
    context = {
        "wallet": request.session["gold"],
    }
    return render(request, "ninja_gold_app/index.html", context)

def process(request):
    if request.method == "POST":
        if "farm" in request.POST:
            request.session["gold"] += random.randint(10,20)
        if "cave" in request.POST:
            request.session["gold"] += random.randint(5,10)
        if "house" in request.POST:
            request.session["gold"] += random.randint(2,5)
        if "casino" in request.POST:
            request.session["gold"] += random.randint(-50,50)
    return redirect("/")

def reset (request):
    request.session.clear
    return redirect("/")