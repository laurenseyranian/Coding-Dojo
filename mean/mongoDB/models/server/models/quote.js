const mongoose = require('mongoose');

const QuoteSchema = new mongoose.Schema({
    name: { type: String, minlength: [2, "Name must be longer than 2 characters."] },
    quote: { type: String, minlength: [5, "Quote must be longer than 5 characters."] },
}, {timestamps: true});
const Quote = mongoose.model('Quote', QuoteSchema);