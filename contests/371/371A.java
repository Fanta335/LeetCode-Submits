class Solution {
  public int maximumStrongPairXor(int[] nums) {
    int n = nums.length, maxXor = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int diff = Math.abs(nums[i] - nums[j]);
        if (diff <= Math.min(nums[i], nums[j])) {
          maxXor = Math.max(maxXor, nums[i] ^ nums[j]);
        }
      }
    }

    return maxXor;
  }
}
