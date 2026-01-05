const express = require('express');
const app = express();
const port = 5500;

app.use(express.urlencoded({extended: true}));
app.use(express.json());

app.get('/register', (req, res) => {
    let name = req.query.user;
    let password = req.query.pwd;
  res.send(`Standard Get Request ${name}`); 
});
app.post('/register', (req, res) => {
    console.log(req.body);
  res.send('Standard Post Request'); 
});
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});