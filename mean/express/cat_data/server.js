const express = require("express");
const app = express();

app.listen(8000, () => console.log("listening on port 8000"));

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.use(express.static(__dirname + "/static"));


app.get("/cats", (req, res) => {
    res.render('cats');
})

app.get("/cats/wiley", (req, res) => {
    var cuddles = [
        {name: "Wiley", fav_food: "Cheese Burgers", age: "15"}, 
    ];
    res.render('details', {cats: cuddles});
})

app.get("/cats/cuddles", (req, res) => {
    var cuddles = [
        {name: "Cuddles", fav_food: "Pesto Pasta", age: "10"}, 
    ];
    res.render('details', {cats: cuddles});
})

app.get("/cats/angel", (req, res) => {
    var cuddles = [
        {name: "Angel", fav_food: "Steak Tacos", age: "5"}, 
    ];
    res.render('details', {cats: cuddles});
})