const express=require('express');
const app=express();
const mongoose=require('mongoose');
const path=require('path'); 
const Chat=require('./models/chat.js');
const methodOverride=require('method-override');



app.set("views",path.join(__dirname,'views'));
app.set('view engine','ejs');

app.use(express.static(path.join(__dirname,'public')));
app.use(express.urlencoded({extended:true}));  
app.use(methodOverride('_method')); 

main().then(()=>{console.log("Connection Sucessfull")}).catch(err => console.log(err));
async function main() {await mongoose.connect('mongodb://127.0.0.1:27017/twitter');}

app.get('/',(req,res)=>{
    res.send('Hello World');
});
//INdex route to display all chats
app.get('/chats',async(req,res)=>{
    try{
        const chats=await Chat.find({});
        console.log(chats);    
        res.render("index.ejs",{chats});
    }catch(err){
        console.log(err);
        res.status(500).send("Internal Server Error");
    }   
});

//Route to create a new chat
app.get('/chats/new',(req,res)=>{
    res.render("new.ejs");
});

//create route to handle form submission
app.post('/chats',express.urlencoded({extended:true}),async(req,res)=>{
    try{
        const {from,To,msg}=req.body;   
        const newChat=new Chat({from,To,msg,created_at:new Date()});        
        await newChat.save();
        res.redirect('/chats');
    }catch(err){
        console.log(err);
        res.status(500).send("Internal Server Error");
    }
});

//edit route to display edit form
app.get('/chats/:id/edit',async(req,res)=>{
    let {id}=req.params;
    let chat=await Chat.findById(id);
    res.render("edit.ejs",{chat});
});

//update route to handle edit form submission
app.put('/chats/:id',async(req,res)=>{
    let {id}=req.params;
    let {msg:newMsg}=req.body;
    let updatedChat=await Chat.findByIdAndUpdate(id,{msg:newMsg},{runValidators:true,new:true });
    
    res.redirect('/chats');
}); 

//delete route to handle chat deletion
app.delete('/chats/:id',async(req,res)=>{
    let {id}=req.params;
    await Chat.findByIdAndDelete(id);
    res.redirect('/chats');
});

app.listen(3000,()=>{
    console.log("Server is running on port 3000");
});