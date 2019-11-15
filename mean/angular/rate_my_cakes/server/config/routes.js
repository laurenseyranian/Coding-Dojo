const mongoose = require('mongoose');
const cakes = require('../controller/cakes.js')
Cake = mongoose.model('Cake');

module.exports = function(app) {

    app.get('/cakes', cakes.index)

    app.post('/create_cake', cakes.create_cake)

    app.post('/create_rating/:id', cakes.create_rating)

    app.get('/read/:id', cakes.read_by_id)

    app.put('/update/:id', cakes.update_by_id)

    app.delete('/delete/:id', cakes.delete_by_id)

}