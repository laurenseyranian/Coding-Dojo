module.exports = {
    index: function (req, res) {
        Cake.find().sort('-createdAt')
            .then(cakes => res.json(cakes))
            .catch(err => res.json(err));
    },
    create_cake: function (req, res) {
        const cake = new Cake(req.body);
        cake.save()
            .then(cake => res.json(cake))
            .catch(err => res.json(err));
    },
    create_rating: function(req, res) {
        Cake.findById({ _id: req.params.id })
        .then(function (cake) {
            cake.ratings.push(req.body)
            return cake.save();
        })
        .then(cake => res.json(cake))
        .catch(err => res.json(err))
    },
    read_by_id: function (req, res) {
        Cake.findOne({ _id: req.params.id })
            .then(cakes => res.json(cakes))
            .catch(err => res.json(err));
    },
    update_by_id: function (req, res) {
        Cake.updateOne({ _id: req.params.id }, {$push: {ratings: req.body }}, {multi:true})
            
            .then(cake => res.json(cake))
            .catch(err => res.json(err));
    },
    delete_by_id: function (req, res) {
        Cake.remove({ _id: req.params.id })
            .then(cakes => res.jason(cakes))
            .catch(err => res.json(err));
    },
};