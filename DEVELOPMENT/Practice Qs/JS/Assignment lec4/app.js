// let arr=[1,2,3,4,5,6,7,8,9];
// let num=parseInt(prompt("Enter the num from 1 to 9 you want delete"));
// let idx=arr.indexOf(num);
// console.log(idx);
// arr.splice(idx,1);
// console.log(arr);
// num=12344335;
// let count=0;
// let sum=0;
// let temp=num;
// while(num!=0){
//     num=Math.floor(num/10);
//     count++;
// }
// console.log(`Count of numebers is :${count}`);
// while(temp!=0){
//     let n1=temp%10;
//     sum+=n1;
//     temp = Math.floor(temp / 10);
// }
// console.log(`Sum of digits present in number is :${sum}`);
// let num=parseInt(prompt("Enter the number you wanted factorial of"));
// let fact=1;
// for(let i=1;i<=num;i++){
//     fact=fact*i;
// }
// console.log(`Factorial of ${num}! is :${fact}`);
let arr=[1,2,3,4,5,6,7,8,9,10];
let max=0;
for(let i=0;i<=arr.length;i++){
    if(max<arr[i]){
        max=arr[i];
    }
}
console.log(`Maximum no. in Array is ${max}`);