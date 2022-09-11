/**
 * @param {number[]} nums
 * @return {number}
 */
const maxSubArray = function (nums) {
  let tmpSum = 0;
  let result = nums[0];

  for (let i = 0; i < nums.length; i++) {
    tmpSum += nums[i];
    result = Math.max(tmpSum, result);
    if (tmpSum < 0) {
      tmpSum = 0;
    }
  }

  return result;
};
console.log(maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]));
