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


mongoose.connect('mongodb://localhost/shoes_db', { useNewUrlParser: true });

const ShoeSchema = new mongoose.Schema({
    brand: { type: String, required: true, minlength: [4, "Brand name required"] },
    description: { type: String, required: true, minlength: [5, "Describe your shoe"] },
    color: { type: String, required: true, minlength: [1, "Color is required"] },
    size: { type: Number, required: true, minlength: [2, "Size is required"] },
});
const Shoe = mongoose.model('Shoe', ShoeSchema);


app.get('/', (req, res) => {
    Shoe.find({})
        .then(data => res.render("index", { shoes: data }))
        .catch(err => res.json(err));
});

app.get('/new', (req, res) => {
    res.render("add");
});

app.post('/new', (req, res) => {
    const shoe = new Shoe(req.body);
    shoe.save()
        .then(() => res.redirect('/'))
        .catch(err => {
            console.log("We have an error!", err);
            for (var key in err.errors) {
                req.flash('shoe', err.errors[key].message);
            }
            res.redirect('/new');
        });
});

app.get('/edit/:id', (req, res) => {
    const id = req.params.id;
    Shoe.findOne({ _id: id })
        .then((shoe) => {
            res.render('edit', { shoe: shoe })
        })
        .catch(err => {
            console.log("We have an error!", err);
        });
});

app.post('/edit/:id', (req, res) => {
    const id = req.params.id;
    Shoe.findByIdAndUpdate(id, req.body)
        .then((shoe) => {
            res.redirect("/")
        })
        .catch(err => {
            console.log("We have an error!", err);
            for (var key in err.errors) {
                req.flash('shoe', err.errors[key].message);
            }
            res.redirect('/edit/' + id);
        });
});

app.get('/view/:id', (req, res) => {
    const id = req.params.id;
    Shoe.findOne({ _id: id })
        .then((shoe) => {
            res.render('display_one', { shoe: shoe })
        })
        .catch(err => {
            console.log("We have an error!", err);
        });
});


app.get('/destroy/:id', (req, res) => {
    const id = req.params.id;
    Shoe.findByIdAndRemove(id, (err) => {
        if (err) {
            console.log("Issue deleting this shoe");
            res.redirect('/');
        } else {
            res.redirect('/')
        }
    });
});

app.listen(8000, () => console.log("listening on port 8000"));