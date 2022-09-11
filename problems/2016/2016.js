const maximumDifference = (nums) => {
  let min = nums[0];
  let diff = -1;

  for(let i = 1; i < nums.length; i++){
    diff = Math.max(diff, nums[i] - min);
    min = Math.min(min, nums[i]);
  }

  return diff === 0 ? -1 : diff;
}

console.log(maximumDifference([7,1,5,4]))
