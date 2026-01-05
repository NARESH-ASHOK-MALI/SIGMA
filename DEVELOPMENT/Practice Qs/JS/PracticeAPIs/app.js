let url="http://universities.hipolabs.com/search?name=india";
let btn=document.querySelector("#btn");

btn.addEventListener("click", async ()=>{
    let State =document.querySelector("input").value;
    console.log(State);
    let colArr= await getColleges();
    show(colArr,State) ;
})

function show(colArr,State){
    let list =document.querySelector("#list");
    list.innerText="";
    for (let col of colArr){
        if(col["state-province"]===State){
            let li =document.createElement("li");
            li.innerText=col.name;
            list.appendChild(li);
        }
    }
    if (list.innerText === "") {
        list.innerHTML = "<li>No colleges found in Maharashtra for this query.</li>";
    }
}
async function getColleges() {
    try{
        let res = await axios.get(url);
        console.log(res.data);
        return res.data;
    }catch(e){
        console.err("Error found:",e);
        return [];
    }
}