/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
  if (Math.abs(x) < 10) return x;

  let isNegative = false;
  if (x < 0) {
    isNegative = true;
    x = x * -1;
  }

  while (x % 10 === 0) {
    x = x / 10;
  }

  let reversedStr = x.toString().split("").reverse().join("");
  let result = parseInt(reversedStr, 10);

  result = isNegative ? result * -1 : result;

  if (result < Math.pow(-2, 31) || result > Math.pow(2, 31) - 1) {
    return 0;
  }

  return result;
};
