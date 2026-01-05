const { faker } = require('@faker-js/faker');
const mysql=require('mysql2');
const express=require('express');
const app=express();
const path=require('path');
const methodOverride=require('method-override');
const { v4: uuidv4 } = require("uuid");


app.use(methodOverride('_method'));
app.use(express.urlencoded({extended:true}));
app.set('view engine','ejs');
app.set("views",path.join(__dirname,'/views'));

const connection = mysql.createConnection({
  host: 'localhost',
  user:"root",
  database:"sigma_app",
    password:"Office@1234"
});

let getRandomUser=()=> {
  return [
    faker.string.uuid(),
    faker.internet.username(),
    faker.internet.email(),
    faker.internet.password(),
  ];
}



app.get('/',(req,res)=>{
    let query="SELECT count(*) as count FROM users";
    try {
        connection.query(query,(err, results) => {
        if (err) throw err;
        let count=results[0].count;
        res.render("home.ejs",{count}); 
        });
      }catch(err){
        console.log(err);
        res.send("Error");  
      }
});
//Show route
app.get('/user',(req,res)=>{
    let query=`SELECT * FROM users`;  
    try {
        connection.query(query,(err, users) => {
        if (err) throw err;
        // console.log(results);
        res.render("users.ejs",{users});
        });
      }catch(err){
        console.log(err);
        res.send("Error");  
      }
});
// Edit Route
app.get('/users/:id/edit',(req,res)=>{
  let {id}=req.params;
  let query=`SELECT * FROM users WHERE id='${id}'`;
  try {
        connection.query(query,(err, users) => {
        if (err) throw err;
        console.log(users);
        let user=users[0];
        res.render("edit.ejs",{user});
        });
      }catch(err){
        console.log(err);
        res.send("Error");  
      }
})
// Update Route
app.patch("/user/:id",(req,res)=>{
  let {id}=req.params;
  let {pwd:formPass,userName:newUsername}=req.body;
  let query=`SELECT * FROM users WHERE id='${id}'`;
  try {
        connection.query(query,(err, users) => {
        if (err) throw err;
            let user=users[0];
        console.log(users);
        console.log(formPass,user.password);
        if(formPass!=user.password){
          return res.send("Password incorrect");
        }else{
          let updateQuery=`UPDATE users SET userName='${newUsername}' WHERE id='${id}'`;
          connection.query(updateQuery,(err, result) => {
            if (err) throw err;
            res.redirect('/user');
          });
        }
        });
      }catch(err){
        console.log(err);
        res.send("Error");  
      }
})
app.get("/user/new", (req, res) => {
  res.render("new.ejs");
});

app.post("/user/new", (req, res) => {
  let { username, email, password } = req.body;
  let id = uuidv4();
  //Query to Insert New User
  let q = `INSERT INTO users (id, username, email, password) VALUES ('${id}','${username}','${email}','${password}') `;

  try {
    connection.query(q, (err, result) => {
      if (err) throw err;
      console.log("added new user");
      res.redirect("/user");
    });
  } catch (err) {
    res.send("some error occurred");
  }
});

app.get("/user/:id/delete", (req, res) => {
  let { id } = req.params;
  let q = `SELECT * FROM users WHERE id='${id}'`;

  try {
    connection.query(q, (err, result) => {
      if (err) throw err;
      let user = result[0];
      res.render("delete.ejs", { user });
    });
  } catch (err) {
    res.send("some error with DB");
  }
});

app.delete("/user/:id/", (req, res) => {
  let { id } = req.params;
  let { password } = req.body;
  let q = `SELECT * FROM users WHERE id='${id}'`;

  try {
    connection.query(q, (err, result) => {
      if (err) throw err;
      let user = result[0];

      if (user.password != password) {
        res.send("WRONG Password entered!");
      } else {
        let q2 = `DELETE FROM users WHERE id='${id}'`; //Query to Delete
        connection.query(q2, (err, result) => {
          if (err) throw err;
          else {
            console.log(result);
            console.log("deleted!");
            res.redirect("/user");
          }
        });
      }
    });
  } catch (err) {
    res.send("some error with DB");
  }
});


app.listen(3000,()=>{
    console.log("server started on port 3000");
});


// let query="INSERT INTO users (id, username, email, password) VALUES ?";

// let user=[];
// for(let i=0;i<94;i++){
//     user.push(getRandomUser());
// }

// try {
//   connection.query(query,[user],(err, results) => {
//     if (err) throw err;
//     console.log(results); 
// });
// }catch(err){
//     console.log(err)
// }
// connection.end();