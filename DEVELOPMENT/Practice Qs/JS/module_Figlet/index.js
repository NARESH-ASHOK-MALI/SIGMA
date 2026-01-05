const figlet =require("figlet")
figlet("Naresh Ashok Mali",function(err,data){
    if(err){
        console.log("Something Went wrong...");
        console.dir(err);
        return;
    }
    console.log(data);
})