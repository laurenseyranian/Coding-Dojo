from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play')
def play():
    return render_template("playground.html")

if __name__=="__main__":
    app.run(debug=True)