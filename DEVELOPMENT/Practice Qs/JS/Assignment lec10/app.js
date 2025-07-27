

let H1=document.querySelector("h1");

H1.addEventListener('mouseover',(e)=>e.target.style.color="orange");
H1.addEventListener('mouseout',(e)=>e.target.style.color="black");

const keyInput = document.getElementById('keyInput');
const keyOutput = document.getElementById('keyOutput');

keyInput.addEventListener('keypress', function(event) {
  // The 'event' object contains info about the event
  // 'event.key' holds the value of the key that was pressed
  keyOutput.textContent = event.key;
  console.log(`Key: ${event.key}, Code: ${event.code}`);
});

window.addEventListener('scroll', function() {
  const scrollableHeight = document.documentElement.scrollHeight - window.innerHeight;
  const scrolledPercentage = (window.scrollY / scrollableHeight) * 100;
  
  const progressBar = document.getElementById('progress-bar');
  progressBar.style.width = scrolledPercentage + '%';
});

window.addEventListener('load', function() {
  // This code only runs after the page AND the image are fully loaded
  const statusElement = document.getElementById('status');
  statusElement.textContent = 'Page and all resources have successfully loaded!';
  statusElement.style.color = 'green';
  console.log('Load event fired!');
});
let button = document.createElement("button");
button.textContent = "Click Me";
document.body.appendChild(button);
button.addEventListener("click", () => button.classList="di");
button.addEventListener("mouseout",()=>button.classList="ci")
const nameInput = document.getElementById("nameInput");
const displayName = document.getElementById("displayName");

nameInput.addEventListener("input", () => {
  // Allow only a-z, A-Z, and space using RegEx
  const filtered = nameInput.value.replace(/[^a-zA-Z ]/g, "");
  
  // Update heading with filtered value
  displayName.textContent = filtered;
});

