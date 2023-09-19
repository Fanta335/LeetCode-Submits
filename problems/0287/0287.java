class Solution {
  public int findDuplicate(int[] nums) {
    int n = nums.length, l = 1, r = n - 1;
    while (l < r) {
      int mid = (l + r) / 2, count = 0;
      for (int num : nums) {
        if (mid >= num) {
          count++;
        }
      }
      if (mid < count) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}
