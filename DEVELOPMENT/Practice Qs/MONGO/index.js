const mongoose = require('mongoose');

async function main() {
    await mongoose.connect('mongodb://127.0.0.1:27017/test');
}

main().then(()=>{console.log("Connection successful")}).catch(err => console.log(err));

const userSchema = new mongoose.Schema({
    name: String,
    email: String,
    age: Number
});
const User=mongoose.model("User",userSchema);
// const user2=new User({
//     name:"Jackson Storm",
//     email:"jacksonstorm@hotmail.com",
//     age:17
// });
// user2.save().then((res)=>{console.log(res,"User saved")}).catch(err => console.log(err));
// User.insertMany([
//     {name:"Lightning McQueen",email:"rusteeze@yahoo.in",age:15},
//     {name:"Sally Carrera",email:"porche@yahoo.in",age:14},
//     {name:"Doc Hudson",email:"ambassador@gmail.com",age:20}
// ]).then((res)=>{console.log(res,"Users saved")}).catch(err => console.log(err));
User.find().then((res)=>{console.log("All users:-",res)}).catch(err => console.log(err));