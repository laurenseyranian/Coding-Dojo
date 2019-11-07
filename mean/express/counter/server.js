const express = require("express");
const app = express();
const session = require('express-session');
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))

app.listen(8000, () => console.log("listening on port 8000"));

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.use(express.static(__dirname + "/static"));

app.get('/', (req, res) => {
    console.log("Value of name in session: ", req.session.name);
    if (!req.session.counter){
        req.session.counter = 1;
    }
    else{
        req.session.counter ++;
    }
    res.render('index', {counter: req.session.counter});
});

app.get('/addTwo', (req, res) => {
    console.log("Value of name in session: ", req.session.name);
    if (!req.session.counter){
        req.session.counter = 1;
    }
    else{
        req.session.counter += 1;
    }
    res.redirect('/');
});

app.get('/reset', (req, res) => {
    console.log("Value of name in session: ", req.session.name);
    req.session.counter = 0
    res.redirect('/');
});
