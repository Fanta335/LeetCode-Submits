/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const twoSum = function (nums, target) {
  let hashmap  = {};
  for(let i = 0; i < nums.length; i++){
    hashmap[nums[i]] = i;
  }
  for(let i = 0; i < nums.length; i++){
    let pair = target - nums[i];
    if((pair in hashmap) && (hashmap[pair] !== i)) return [i, hashmap[pair]];
  }
};

// const twoSum = function (nums, target) {
//   for(let i = 0; i < nums.length; i++){
//     for(let j = i+1; j < nums.length; j++){
//       if(nums[i] + nums[j] === target) return [i, j];
//     }
//   }
// };

console.log(twoSum([1, 2, 3], 5));
