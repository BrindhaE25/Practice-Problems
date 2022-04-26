numbers = [2,3,4,5,6]
sum = 0;
function doubleMap(number) {
    return number*number;
}
function checkIfEven(number) {
    if(number%2==0)
    return number;
}
function sumArray(number) {
    sum = sum+number;
    return sum;
}
function getElement(number) {
    return number;
}
const calculate = function(numbers,logic) {
    let output = []
    for(iter=0;iter < numbers.length;iter++) {
        result = logic(numbers[iter]);
        if(result)
        output.push(result);
    }
    return output;
    
}
console.log("map function without inbuilt function");
console.log(calculate(numbers,doubleMap));
console.log("filter function without inbuilt function");
console.log(calculate(numbers,checkIfEven));
console.log("reduce function without inbuilt function");
calculate(numbers,sumArray);
console.log(sum);
console.log("for each function without inbuilt function");
console.log(calculate(numbers,getElement));
