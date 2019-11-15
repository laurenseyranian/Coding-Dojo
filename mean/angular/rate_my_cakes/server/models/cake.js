const mongoose = require('mongoose');

const CakeSchema = new mongoose.Schema({
    name: { type: String, required: true, minlength: 2 },
    image: { type: String, required: true, minlength: 2 },
    ratings: [{
            rating: { type: Number, required: true, max: 5 },
            comment: { type: String, required: true, minlength: 2 },
        }],
}, { timestamps: true });

const Cake = mongoose.model('Cake', CakeSchema);