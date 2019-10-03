from flask import Flask, render_template     # Import Flask to allow us to create our app
app = Flask(__name__)       # Create a new instance of the Flask class called "app"

@app.route('/')             # The "@" decorator associates this route with the function immediately following
def hello_world():
    return 'Hello World!'   # Return the string 'Hello World!' as a responsecopy
@app.route('/success')
def success():
  return "success"
@app.route("/lauren")
def hello_person():
    print("*"*80)
    return "Hello Lauren!"
@app.route('/hello/<name>') # for a route '/hello/____' anything after '/hello/' gets passed as a variable 'name'
def hello(name):
    print(name)
    return "Hello, " + name
@app.route('/users/<username>/<id>') # for a route '/users/____/____', two parameters in the url get passed as username and id
def show_user_profile(username, id):
    print(username)
    print(id)
    return "username: " + username + ", id: " + id

@app.route("/<name>/<times>")
def hello_name(name, times):
    print("*"*80)
    print("in hello_name function")
    print(name)
    #return render_template("hello2.html", some_name=name, num_times=int(times))

@app.route('/coding')
def coding():
    #return render_template("hello.html", phrase="hello", times=5) #must delete one of renders in order to work

@app.route('/lists')
def render_lists():
    student_info = [
        {'name' : 'Michael', 'age' : 35},
        {'name' : 'John', 'age' : 30 },
        {'name' : 'Mark', 'age' : 25},
        {'name' : 'KB', 'age' : 27}
    ]
    return render_template("hello3.html", random_numbers = [3,1,5], students = student_info)


if __name__=="__main__":
    app.run(debug=True)
