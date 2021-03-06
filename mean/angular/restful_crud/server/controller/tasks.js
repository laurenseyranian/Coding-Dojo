module.exports = {
    index: function(req, res) {
        Task.find().sort('-createdAt')
        .then(tasks => res.json(tasks))
        .catch(err => res.json(err));
    },
    create: function(req, res) {
        const task = new Task(req.body);
        task.save()
        .then(tasks => res.json(tasks))
        .catch(err => res.json(err));
    },
    view_by_id: function(req, res) {
        Task.findOne({_id : req.params.id})
        .then(tasks => res.json(tasks))
        .catch(err => res.json(err));
    },
    update_by_id: function(req, res) {
        Task.findOne({_id : req.params.id})
        .then (function(task){
            if(req.body.title){
                task.title = req.body.title;
            }
            if(req.body.description){
                task.description = req.body.description;
            }
            if(req.body.complete){
                task.complete = req.body.complete;
            }
            return task.save()
        })
        .then(tasks => res.json(tasks))
        .catch(err => res.json(err));
    },
    delete_by_id: function(req, res) {
        Task.remove({_id: req.params.id})
        .then(tasks => res.jason(tasks))
        .catch(err => res.json(err));
    },
};