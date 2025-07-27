let btn=document.querySelector("button");
let ul=document.querySelector("ul");
let inp=document.querySelector("input");

btn.addEventListener("click",function(){
    let item=document.createElement("li");
    item.innerText=inp.value;
    ul.appendChild(item);
    let delBtn=document.createElement("button");
    delBtn.innerText="Completed";
    delBtn.classList="Delete";
    item.appendChild(delBtn);
    console.log(inp.value);
    inp.value="";
})

ul.addEventListener("click",function(e){
    if (e.target.nodeName=="BUTTON") {
        let listItem=e.target.parentElement;
        listItem.remove();
        console.log(`${listItem.innerText}`)
    }
})
// let delBtns=document.querySelectorAll(".Delete"); Event delegation happens and it does not applies over 
// // for(delBtn of delBtns){                         newly added elements hence wrong code
//     delBtn.addEventListener("click",function(){
//         let par =this.parentElement;
//         console.log(par);
//         par.remove();
//     });
// }