function minMaxAvg(arr) {
    var min = arr[0];
    var max = arr[0];
    var sum = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
        if (arr[i] < min) {
            min = arr[i];
        }
        sum += arr[i];
    }
    var avg = sum / arr.length
    console.log("The minimum is " + min + ", the maximum is " + max + ", the average is " + avg + ".");
}
minMaxAvg([1, 3, 5, 7, 9])

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function fizzBuzz(n) {
    for (var i = 1; i <= n; i++) {
        if (i % 5 === 0 && i % 3 === 0) {
            console.log('FizzBuzz');
        } else if (i % 3 === 0) {
            console.log('Fizz');
        } else if (i % 5 === 0) {
            console.log('Buzz');
        } else {
            console.log(i);
        }
    }
}
fizzBuzz(15)

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function validPren(str) {
    var count = 0;
    for (var i = 0; i < str.length; i++) {
        if (str.charAt(i) == "(" || str.charAt(i) == "[" || str.charAt(i) == "{") {
            count++;
        }
        if (str.charAt(i) == ")" || str.charAt(i) == "]" || str.charAt(i) == "}") {
            count--;
        }
        if (count < 0) {
            return false;
        }
    }
    if (count !== 0) {
        return false;
    }
    return true;
}
console.log(validPren("([{)()}])"))

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function bubbleSort(arr) {
    for (var j = 0; j < arr.length - 1; j++) {
        var countswaps = 0;
        for (var i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                countswaps++;
            }
        }
        if (countswaps === 0) {
            break;
        }
    }
    return arr;
}

console.log(bubbleSort([4, 2, 45, 2, -3]))

function coinChange(num) {
    var coin_dict = {
        "dollar": Math.floor(num / 100),
        "quarter": Math.floor((num % 100) / 25),
        "dime": Math.floor((num % 25) / 10),
        "nickle": Math.floor((num % 25 % 10) / 5),
        "penny": Math.floor(num % 5)
    }
    console.log(coin_dict);
}
coinChange(312);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function userLanguages() {
    var users = [
        {
            fname: "Kermit",
            lname: "the Frog",
            languages: ["Python", "JavaScript", "C#", "HTML", "CSS", "SQL"],
            interests: {
                music: ["guitar", "flute"],
                dance: ["tap", "salsa"],
                television: ["Black Mirror", "Stranger Things"]
            }
        },
        {
            fname: "Winnie",
            lname: "the Pooh",
            languages: ["Python", "Swift", "Java"],
            interests: {
                food: ["honey", "honeycomb"],
                flowers: ["honeysuckle"],
                mysteries: ["Heffalumps"]
            }
        },
        {
            fname: "Arthur",
            lname: "Dent",
            languages: ["JavaScript", "HTML", "Go"],
            interests: {
                space: ["stars", "planets", "improbability"],
                home: ["tea", "yellow bulldozers"]
            }
        }
    ]

    for (var user of users) {
        console.log(`${user.fname} ${user.fname} knows ${user.languages}`)
    }
}
userLanguages(users);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function binarySearch (arr, target, start, end){
    console.log(start, end);
    if(end-start<=1){
      if(arr[start]==target){
        return start;
      }else{
        return -1;
      }
    }else{
      if(arr[Math.floor((end-start)/2) + start]>target){
        return binarySearch(arr, target, start, Math.floor(((end-start)/2) +start));    
      }
      else{
        return binarySearch(arr, target, Math.floor(((end-start)/2) + start), end);
      }
    }
  }
  console.log(binarySearch([1, 3, 8, 10, 12, 15, 17, 20, 22, 34, 38, 40, 50, 52, 78, 87, 90, 91, 92, 94], 15, 0, 20))
