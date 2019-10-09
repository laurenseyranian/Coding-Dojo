from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def list():
    users = [
        {'first_name' : 'Nia', 'last_name' : 'Simone', 'email' : 'nia@aol.com'},
        {'first_name' : 'Kristen', 'last_name' : 'Seyranian', 'email' : 'kristen@aol.com'},
        {'first_name' : 'Mark', 'last_name' : 'Seyranian', 'email' : 'mark@aol.com'},
        {'first_name' : 'Bryce', 'last_name' : 'Andrews', 'email' : 'bryce@aol.com'}
    ]
    return render_template("index.html", users=users)

if __name__=="__main__":
    app.run(debug=True)