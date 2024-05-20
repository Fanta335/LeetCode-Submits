class Solution {
  int sum = 0;

  public int subsetXORSum(int[] nums) {
    sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      helper(nums, i + 1, nums[i]);
    }

    return sum;
  }

  private void helper(int[] nums, int idx, int curr) {
    if (idx == nums.length) {
      return;
    }
    helper(nums, idx + 1, curr);
    curr = curr ^ nums[idx];
    System.out.println(curr);
    sum += curr;
    helper(nums, idx + 1, curr);
  }
}
