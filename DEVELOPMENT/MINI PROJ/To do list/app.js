let todo=[];

let req = prompt("Please enter your request");
while (true) {
    if (req=="Quit"||req=="quit") {
        console.log("Quiting app....");
        break;
    }
    if(req=="list"){
        console.log("-----------");
        for(let i=0;i<todo.length;i++){
            console.log(i,todo[i]);
        }
        console.log("-----------");
    }else if(req=="add"){
        let task=prompt("Please enter the task you want add ...")
        todo.push(task);
        console.log("Task added");
    }else if(req=="Delete"||req=="delete"){
        let idx=prompt("Please enter the task you want to delete.");
        todo.splice(idx,1);
        console.log("Task deleted...");
    }else{
        console.log("Wrong request..");
    }
    req=prompt("Please enter your request");
}