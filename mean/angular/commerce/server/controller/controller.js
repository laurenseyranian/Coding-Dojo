module.exports = {
    index: function (req, res) {
        Product.find().sort('-createdAt')
            .then(products => res.json(products))
            .catch(err => res.json(err));
    },
    create: function (req, res) {
        const product = new Product(req.body);
        product.save()
            .then(products => res.json(products))
            .catch(err => res.json(err));
    },

    read_by_id: function (req, res) {
        Product.findOne({ _id: req.params.id })
            .then(products => res.json(products))
            .catch(err => res.json(err));
    },
    update_by_id: function (req, res) {
        Product.findByIdAndUpdate(req.params.id, req.body, { new: true, runValidators: true, context: 'query' })
            .then(products => res.json(products))
            .catch(err => res.json(err));
    },
    delete_by_id: function (req, res) {
        Product.remove({ _id: req.params.id })
            .then(products => res.json(products))
            .catch(err => res.json(err));
    },
};