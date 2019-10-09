from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'
 

@app.route("/")
def root():
    if 'count' not in session:
        session['count'] = 1
    else :
        session['count'] += 1
    return render_template("index.html", count = session['count'])

@app.route("/destroy_session")
def destroy_session():
    session.clear()
    return redirect("/")

@app.route("/addTwo")
def addTwo():
    session['count'] += 1
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)