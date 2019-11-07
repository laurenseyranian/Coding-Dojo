const express = require("express");
const app = express();
const mongoose = require('mongoose');
const session = require('express-session');
const flash = require('express-flash');


app.use(flash());
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
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
    name: { type: String, required: true, minlength: 2 },
    quote: { type: String, required: true, minlength: 5 },
}, {timestamps: true});
const Quote = mongoose.model('Quote', QuoteSchema);


app.get('/', (req, res) => {
    res.render('index');
});

app.post('/quotes', (req, res) => {
    const quote = new Quote(req.body);
    quote.save()
        .then(() => res.redirect('/quotes'))
        .catch(err => {
            console.log("We have an error!", err);
            for (var key in err.errors) {
                req.flash('quote', err.errors[key].message);
            }
            res.redirect('/');
        });
});

app.get('/quotes', (req, res) => {
    Quote.find().sort('-createdAt')
        .then(data => res.render("quotes", { quotes: data }))
        .catch(err => res.json(err));
});

app.listen(8000, () => console.log("listening on port 8000"));