const express = require('express');
const app = express();
const path = require('path');

const port = 8080;

app.set('view engine', 'ejs');
app.set("views",path.join(__dirname, "/views"));

app.get('/', (req, res) => {
    res.render("home");
});

app.get("/hello",(req, res)=>{
    res.send("hello");
})
app.get("/ig/:username",(req, res)=>{
    let {username} = req.params;
    const instaData= require("./data.json");
    const data=instaData[username];
    console.log(data);
    res.render("instagram",{data});
})
app.get("/rolldice",(req, res)=>{
    let dice1 = Math.floor(Math.random() * 6) + 1;
    res.render("rolldice", { dice1: dice1 });
})

app.listen(port, () => {
    console.log(`Servers are running on http://localhost:${port}`);
})