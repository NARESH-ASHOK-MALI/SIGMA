const mongoose=require('mongoose');
const Chat=require('./models/chat.js');

main().then(()=>{console.log("Connection Sucessfull")}).catch(err => console.log(err));
async function main() {await mongoose.connect('mongodb://127.0.0.1:27017/twitter');}


let allChats=([
    {
    from:"Alice",
    To:"Bob",
    msg:"Hello Bob!",
    created_at:new Date()
    },
    {
    from:"Leo",
    To:"Atharva",
    msg:"Hello Atharva!",
    created_at:new Date()
    },
    {
    from:"Shantanu",
    To:"Pratik",
    msg:"Hello pratik!",
    created_at:new Date()
    },
    {
    from:"Rajesh",
    To:"Tejas",
    msg:"Hello tejas!",
    created_at:new Date()
    },
    {
    from:"Mahesh",
    To:"Rahul",
    msg:"Hello rahul!",
    created_at:new Date()
    }
]);

Chat.insertMany(allChats).then((res)=>{console.log(res)}).catch((err)=>{console.log(err)});


