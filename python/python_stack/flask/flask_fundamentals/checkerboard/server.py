from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def play():
    return render_template("index.html", x=8, y=8, color1="aquamarine", color2="plum")

@app.route('/4')
def four():
    return render_template("index.html", x=8, y=4, color1="aquamarine", color2="plum")

@app.route('/<x>/<y>')
def x_y (x,y):
    return render_template("index.html", x = int(x), y=int(y), color1="aquamarine", color2="plum")


if __name__=="__main__":
    app.run(debug=True)