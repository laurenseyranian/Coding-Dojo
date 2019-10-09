from flask import Flask, render_template, request, redirect

import datetime

app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():

    strawberries = request.form['strawberry']
    raspberries = request.form['raspberry']
    apples = request.form['apple']
    blackberries = request.form['blackberry']
    first_name = request.form['first_name']
    last_name = request.form['last_name']
    student_id = request.form['student_id']
    currentDT = datetime.datetime.now()
    
    print(request.form)

    print (str(currentDT))

    return render_template("checkout.html", strawberries=int(strawberries), raspberries=int(raspberries), apples=int(apples), blackberries=int(blackberries),first_name=first_name, last_name=last_name, student_id=student_id, currentDT=currentDT)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    