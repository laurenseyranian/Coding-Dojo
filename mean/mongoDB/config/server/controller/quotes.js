module.exports = {
    render_index: function (req, res) {
        res.render('index')
    },
    show_quotes: function (req, res) {
        Quote.find().sort('-createdAt')
            .then(data => res.render('quotes', { quotes: data }))
            .catch(err => res.json(err));
    },
    new_quote: function (req, res) {
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
    },
};