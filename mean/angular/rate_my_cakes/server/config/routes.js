const mongoose = require('mongoose');
Cake = mongoose.model('Cake');
const cakes = require('../controller/cakes.js')

module.exports = function(app) {

    app.get('/cakes', cakes.index)

    app.post('/create_cake', cakes.create_cake)

    app.post('/create_rating/:id', cakes.create_rating)

    app.get('/show/:id', cakes.read_by_id)

    app.put('/update/:id', cakes.update_by_id)

    app.delete('/delete/:id', cakes.delete_by_id)

}