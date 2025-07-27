let button=document.createElement("button");
let input=document.createElement("input");
button.innerText="Clickme";

document.querySelector("body").append(input);
document.querySelector("body").append(button);

 button.setAttribute("id","btn");
 input.setAttribute("placeholder","username");

 let btn=document.querySelector("#btn");
 btn.classList.add("btnStyle");

let h1 =document.createElement("h1");
h1.innerHTML="<u>DOMPractice</u>";
document.querySelector("body").append(h1);

let p=document.createElement("p");
p.innerHTML="ApnaCollege<b>Delta</b>Practice";
document.querySelector("body").append(p);
