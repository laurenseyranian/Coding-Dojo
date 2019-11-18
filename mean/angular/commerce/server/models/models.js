const mongoose = require('mongoose');

const ProductSchema = new mongoose.Schema({
    name: { type: String, minlength: [3, "Product must contain a name"], default: ""},
    quantity: { type: Number, min: [2, "Product must contain a value greater than 0"], required: [true, "Product must contain a quantity"], default: ""},
    price: { type: Number, min: [2, "Product must contain a value greater than 0"], required: [true, "Product must contain a quantity"], default: ""},
}, { timestamps: true });

const Product = mongoose.model('Product', ProductSchema);
