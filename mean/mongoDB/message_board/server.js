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


mongoose.connect('mongodb://localhost/message_db', { useNewUrlParser: true });
const CommentSchema = new mongoose.Schema({
    name: { type: String, required: [true, "Name is required"] },
    comment: { type: String, required: [true, "Comment must have content"] },
}, { timestamps: true })
const Comment = mongoose.model('Comment', CommentSchema);

const MessageSchema = new mongoose.Schema({
    name: { type: String, required: [true, "Name is required"] },
    message: { type: String, required: [true, "Message must have content"] },
    comments: [CommentSchema]
}, { timestamps: true })
const Message = mongoose.model('Message', MessageSchema);


app.get('/', (req, res) => {
    Message.find({})
        .then(data => res.render("index", { msgs: data },))
        .catch(err => res.json(err));
});

app.post('/new_message', (req, res) => {
    const message = new Message(req.body);
    message.save()
        .then(() => res.redirect('/'))
        .catch(err => {
            console.log("We have an error!", err);
            for (var key in err.errors) {
                req.flash('message', err.errors[key].message);
            }
            res.redirect('/');
        });
});


app.post('/new_comment/:id', (req, res) => {
    var id = req.params.id
    const comment= new Comment(req.body);
    comment.save()
        .then((data) => {
            return Message.findOneAndUpdate({_id: id}, {$push: {comments: data}})
        })
        .then (() => {
            res.redirect('/')
        })
        .catch(err => {
            console.log("We have an error!", err);
            for (var key in err.errors) {
                req.flash([id], err.errors[key].message);
            }
            res.redirect('/');
        });
});



app.listen(8000, () => console.log("listening on port 8000"));