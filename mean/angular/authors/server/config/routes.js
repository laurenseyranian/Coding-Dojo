const mongoose = require('mongoose');
Author = mongoose.model('Author');
const controller = require('../controller/controller.js')

module.exports = function(app) {
    app.get('/authors_json', controller.index)

    app.post('/create_json', controller.create)

    app.get('/read_json/:id', controller.read_by_id)

    app.put('/update_json/:id', controller.update_by_id)

    app.delete('/delete_json/:id', controller.delete_by_id)

}