from flask import Flask, render_template, request
app = Flask(__name__)


@app.route("/")
def index():
    return render_template("index.html")

@app.route("/process", methods=["POST"])
def process_user():
    return render_template("info.html", name=request.form["username"], email=request.form["email"])

if __name__ == "__main__":
    app.run(debug=True)