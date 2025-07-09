// let num=9;
// if (num%10==0) {
//     console.log("Good")
// } else {
//     console.log("Bad")
// }
// let userName=prompt("Enter user name!");
// let userAge=prompt("Enter your age!");
// alert(`${userName} is ${userAge} years old`);
let quarter=1;
switch (quarter) {
    case 1:
        console.log("Months in Quarter1: January , February , March");
        break;
    case 2:
        console.log("Months in Quarter2: April , May , June");
        break;
    case 3:
        console.log("Months in Quarter3: July , August , September");
        break;
    case 4:
        console.log("Months in Quarter4: October , November , December");
        break;

    default:
        console.error("Wrong Input");
        break;
}
let string="Alphabet";
if ((string[0]=="A" || string[0]=="a") &&5<string.length ) {
    console.log("String is Golden String");
} else {
     console.log("Not a golden string");
}
let a=10 , b=55, c= 19;
if(a>b&&a>c){
    console.log("A is greatest")
}else if(b>a&&b>c){
    console.log("B is the greatest one.")
}else{
    console.log("C is greatest.")
}
let x = 32 , y = 4785;
if (x%10==y%10) {
    console.log("Both number's last digit is same.")
} else {
    console.log("No digits are not same.")
}