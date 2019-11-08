const express = require("express");
const app = express();
const mongoose = require('mongoose');
const session = require('express-session');
const flash = require('express-flash');

app.use(flash());
app.set('view engine', 'ejs');
app.set('views', __dirname + '/client/views');
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + "/static"));
app.use(session({
    secret: 'keyboardkitteh',
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 }
}))


mongoose.connect('mongodb://localhost/quotes_db', { useNewUrlParser: true });

const QuoteSchema = new mongoose.Schema({
    name: { type: String, minlength: [2, "Name must be longer than 2 characters."] },
    quote: { type: String, minlength: [5, "Quote must be longer than 5 characters."] },
}, {timestamps: true});
const Quote = mongoose.model('Quote', QuoteSchema);

require('./server/config/routes.js')(app)

app.listen(8000, () => console.log("listening on port 8000"));