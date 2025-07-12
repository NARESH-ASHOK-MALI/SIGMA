let arr=[7,9,0,-2];
let n=3;
let arr1=arr.slice(0,n);
console.log(arr1);
let arr2=arr.slice(-n);
console.log(arr2);
// let str=prompt("Enter the proper string");
// if (str.length==0) {
//     console.log("String is empty.");
// } else {
//     console.log("String entered properly.");
// }
// let idx=prompt("Provide number to check the lower case of particular index.");
// if (str[idx]==str[idx].toLowerCase()) {
//     console.log("Character is in lowercase");
// } else {
//     console.log("Character is not in lowercase");
// }
console.log("clearing all leading and trailing spaces in Provided string");
str1="            Naresh            ";
console.log(str1);
let str2=str1.trim();
console.log(str2);
let arr3=["hello",'a',23,64,99,-6];
let item = 64;
if(arr3.indexOf(item)!=-1){
    console.log("element exists in array");
}else{
    console.log("element doesn't exist in array");
}