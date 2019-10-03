from flask import Flask
app = Flask(__name__)

#1
@app.route('/')
def hello_world():
    return 'Hello World!'

#2
@app.route('/dojo')
def dojo():
    return 'Dojo'

#3
@app.route('/say/<name>')
def hi_name(name):
    print("*"*80)
    print("in hi_name function")
    print(name)
    return f"Hi {name}!"

#4
@app.route('/repeat/<number>/<word>/')
def repeat(number,word):
    print("*"*80)
    print(int(number))
    print(word)
    return int(number)*word

#5
@app.route('/repeat/<number>/<int:item>')
def repeat(number, item):
    return number * item



if __name__=="__main__":
    app.run(debug=True)
