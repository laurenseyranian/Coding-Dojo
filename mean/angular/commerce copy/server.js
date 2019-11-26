const express = require("express");
const app = express();
const mongoose = require('mongoose');
const flash = require('express-flash');
const bodyParser = require('body-parser');
const path = require('path')

app.use(bodyParser.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(express.static( __dirname + '/public/dist/public' ));


mongoose.connect('mongodb://localhost/products_db', { useNewUrlParser: true });

require('./server/models/models.js')
require('./server/config/mongoose.js')
require('./server/config/routes.js')(app)


app.all("*", (req,res,next) => {
    res.sendFile(path.resolve("./public/dist/public/index.html"))});
app.listen(8000, () => console.log("listening on port 8000"));