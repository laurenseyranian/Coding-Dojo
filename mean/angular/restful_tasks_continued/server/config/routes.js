const mongoose = require('mongoose');
Task = mongoose.model('Task');
const tasks = require('../controller/tasks.js')

module.exports = function(app) {
    app.get('/tasks', tasks.index)
    
    app.get('/view/:id', tasks.view_by_id)

    app.post('/create', tasks.create)

    app.put('/update/:id', tasks.update_by_id)

    app.delete('/delete/:id', tasks.delete_by_id)
}