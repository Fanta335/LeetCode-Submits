class Solution {
  public int[] getSumAbsoluteDifferences(int[] nums) {
    int n = nums.length, left = 0, right = 0;
    for (int i = 1; i < n; i++) {
      right += nums[i];
    }

    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = (nums[i] * i - left) + (right - nums[i] * ((n - 1) - i));
      left += nums[i];
      if (i < n - 1) {
        right -= nums[i + 1];
      }
    }
    return ans;
  }
}
