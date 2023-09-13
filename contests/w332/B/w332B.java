import java.util.Arrays;

class w332B {
  public long countFairPairs(int[] nums, int lower, int upper) {
    Arrays.sort(nums);
    long res = 0;
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      int l = i + 1, r = N - 1;
      while (l < r) {
        int mid = (r - l) / 2 + l;
        if (nums[i] + nums[mid] >= lower) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
      int itr1 = l;
      l = i + 1;
      r = N - 1;
      while (l < r) {
        int mid = (r - l) / 2 + l;
        if (nums[i] + nums[mid] <= upper) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      int itr2 = l - 1;
      res += itr2 - itr1;
    }
    return res;
  }
}
