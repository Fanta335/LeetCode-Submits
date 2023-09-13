class Solution {
  public int maximumCount(int[] nums) {
    int N = nums.length;
    int l = 0, r = N - 1;

    if (nums[l] == 0 && nums[r] == 0) {
      return 0;
    }
    if (nums[r] < 0 || nums[l] > 0) {
      return N;
    }

    while (l < r) {
      int mid = (r + l) / 2;
      if (nums[mid] < 0) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    int count = l;
    l = 0;
    r = N - 1;
    while (l < r) {
      int mid = (r + l) / 2;
      if (nums[mid] > 0) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    count = Math.max(count, N - r);
    return count;
  }
}
