let gameSeq=[];
let userSeq=[];

let btns=["red","yellow","blue","green"]
let started=false;
let level=0;

let h2=document.querySelector("h2");

document.addEventListener("keypress",function(){
    if (started==false) {
        console.log("Game started!");
        started=true;

        levelUp();
    }
})

function gameFlash(btn){
    btn.classList.add("flash");
    setTimeout(function(){
        btn.classList.remove("flash");
    },200)
}
function userFlash(btn){
    btn.classList.add("userFlash");
    setTimeout(function(){
        btn.classList.remove("userFlash");
    },200)
}

function levelUp() {
    userSeq=[];
    level++;
    h2.innerText=`Level   ${level}`;

    let randIdx=Math.floor(Math.random()*3);
    let randomCol=btns[randIdx];
    let randBtn=document.querySelector(`.${randomCol}`);
    gameSeq.push(randomCol);
    console.log(gameSeq);
    
    gameFlash(randBtn);
}

function checkAns(idx){
    // console.log("Current level ",level);
    // let idx=level - 1;
    if (userSeq[idx]===gameSeq[idx]) {
        if(userSeq.length == gameSeq.length){
            setTimeout(levelUp,1000);
        }
    }else{
        h2.innerHTML=`Game Over your score was <b>${level}</b> <br>Press Any key to restart`;
        document.querySelector("body").style.backgroundColor="red";
        setTimeout(function(){
            document.querySelector("body").style.backgroundColor="black";
        },150)
        reset();
    }

}

function btnPress(){
    let btn=this;
    userFlash(btn);

    userCol=btn.getAttribute("id");
    userSeq.push(userCol);
    console.log(userSeq);
    checkAns(userSeq.length -1);

}

let allBtns=document.querySelectorAll(".btn");
for(btn of allBtns){
    btn.addEventListener("click",btnPress);
}
function reset() {
    started=false;
    gameSeq=[];
    userSeq=[];
    level=0;
}