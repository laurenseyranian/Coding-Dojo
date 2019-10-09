from flask import Flask, render_template, request, redirect
app = Flask(__name__)

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/result', methods=['POST'])
def submission():
    name = request.form['name']
    email = request.form['email']
    gender = request.form['gender']
    language = request.form['language']
    comment = request.form['comment']
    
    return render_template('show.html', name=request.form['name'], email=request.form ['email'], gender=request.form ['gender'], language=request.form ['language'], comment=request.form ['comment'])

if __name__ == "__main__":
    app.run(debug=True)
