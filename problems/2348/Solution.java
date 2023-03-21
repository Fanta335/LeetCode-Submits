class Solution {
  private long countZeroSubarray(int[] nums, int start, int end) {
    long res = 0;
    int N = end - start, len = 1;
    while (len <= N) {
      res += N - len + 1;
      len++;
    }
    return res;
  }

  public long zeroFilledSubarray(int[] nums) {
    long count = 0;
    int N = nums.length, idx = 0, start = 0;
    while (idx < N) {
      if (nums[idx] == 0) {
        start = idx;
        while (idx < N && nums[idx] == 0) {
          idx++;
        }
        count += countZeroSubarray(nums, start, idx);
      } else {
        idx++;
      }
    }
    return count;
  }
}
