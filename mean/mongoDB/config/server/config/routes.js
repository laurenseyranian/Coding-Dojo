const mongoose = require('mongoose');
Quote = mongoose.model('Quote');
const quotes = require('../controller/quotes.js')

module.exports = function (app) {
    app.get('/', function (req, res) {
        quotes.render_index(req, res);
    });

    app.post('/quotes', function (req, res) {
        quotes.new_quote(req, res);
    });

    app.get('/quotes', function (req, res) {
        quotes.show_quotes(req, res);
    });
}