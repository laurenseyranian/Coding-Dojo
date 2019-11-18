module.exports = {
    index: function (req, res) {
        Author.find().sort('-createdAt')
            .then(authors => res.json(authors))
            .catch(err => res.json(err));
    },
    create: function (req, res) {
        const author = new Author(req.body);
        author.save()
            .then(authors => res.json(authors))
            .catch(err => res.json(err));
    },

    read_by_id: function (req, res) {
        Author.findOne({ _id: req.params.id })
            .then(authors => res.json(authors))
            .catch(err => res.json(err));
    },
    update_by_id: function (req, res) {
        Author.findByIdAndUpdate(req.params.id, req.body)
            .then(authors => res.json(authors))
            .catch(err => res.json(err));
    },
    delete_by_id: function (req, res) {
        Author.remove({ _id: req.params.id })
            .then(authors => res.json(authors))
            .catch(err => res.json(err));
    },
};