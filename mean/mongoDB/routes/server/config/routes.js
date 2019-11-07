const mongoose = require('mongoose'),
      Quote = mongoose.model('Quote')
module.exports = function(app){
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
}  