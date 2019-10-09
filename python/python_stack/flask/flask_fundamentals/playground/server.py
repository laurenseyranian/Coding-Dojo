from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play')
def play():
    return render_template("index.html", number=3, color="lightblue")

@app.route('/play/<number>/')
def play_x(number):
    return render_template("index.html", number=int(number), color="lightblue")

@app.route('/play/<number>/<color>')
def play_x_color(number, color):
    return render_template("index.html", number=int(number), color=color)

if __name__=="__main__":
    app.run(debug=True)