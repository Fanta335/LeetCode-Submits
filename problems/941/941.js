/**
 * @param {number[]} arr
 * @return {boolean}
 */
const validMountainArray = (arr) => {
  if(arr.length < 3) return false;

  let passedPeak = false;

  for (let i = 1; i < arr.length; i++) {
    let curr = arr[i];
    if(i === 1 && curr <= arr[i-1]) return false;
    
    if (curr === arr[i - 1]) return false;
    else if(!passedPeak && curr < arr[i-1]){
      passedPeak = true;
    }
    else if(passedPeak && curr >= arr[i-1]) return false;
  }

  if(!passedPeak) return false;

  return true;
};

console.log(validMountainArray([2,1]));
console.log(validMountainArray([3,5,5]));
console.log(validMountainArray([0,3,2,1]));
