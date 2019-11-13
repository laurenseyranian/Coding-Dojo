const mongoose = require('mongoose');

const TaskSchema = new mongoose.Schema({
    title: { type: String, default: ""},
    description: { type: String, default: ""},
    complete: { type: Boolean, default: false},
}, {timestamps: true});

const Task = mongoose.model('Task', TaskSchema);