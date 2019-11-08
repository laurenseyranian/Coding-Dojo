const express = require("express");
const app = express();
const mongoose = require('mongoose');
const session = require('express-session');
const flash = require('express-flash');
const bodyParser = require('body-parser');

app.set('view engine', 'ejs');
app.set('views', __dirname + '/client/views');
app.use(flash());
app.use(bodyParser.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
// app.use(express.static(__dirname + "/static"));
app.use(express.static( __dirname + '/public/dist/public' ));
app.use(session({
    secret: 'keyboardkitteh',
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 }
}))


mongoose.connect('mongodb://localhost/tasks_db', { useNewUrlParser: true });


require('./server/config/mongoose.js')
require('./server/config/routes.js')(app)


app.listen(8000, () => console.log("listening on port 8000"));