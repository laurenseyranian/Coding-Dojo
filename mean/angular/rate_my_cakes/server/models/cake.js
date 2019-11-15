const mongoose = require('mongoose');

const CakeSchema = new mongoose.Schema({
    name: { type: String, default: "" },
    image: { type: String, default: "" },
    avgRating : { type: Number, default: 0},
    ratings: [{
            rating: { type: Number, default: 0 },
            comment: { type: String, default: "" },
        }],
}, { timestamps: true });

const Cake = mongoose.model('Cake', CakeSchema);