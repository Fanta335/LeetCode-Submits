/**
 * @param {number} x
 * @return {boolean}
 */
 const numToArray = (num) => {
  let curr = num;
  let result = [];

  while (curr >= 1) {
    result.push(curr % 10);
    curr = Math.floor(curr / 10);
  }

  return result;
};

var isPalindrome = function (x) {
  if (x < 0) return false;

  const arr = numToArray(x);
  for (let i = 0; i < arr.length / 2; i++) {
    if (arr[i] !== arr[arr.length - 1 - i]) return false;
  }

  return true;
};

console.log(isPalindrome(121));
