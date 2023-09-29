class Solution {
  public boolean isMonotonic(int[] nums) {
    if (nums.length <= 2) {
      return true;
    }
    int lastBigger = -1, lastSmaller = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }
      if (nums[i] > nums[i - 1]) {
        lastSmaller = i - 1;
      } else {
        lastBigger = i - 1;
      }
      if (lastBigger >= 0 && lastSmaller >= 0) {
        return false;
      }
    }
    return true;
  }
}
