class Solution {
  public int jump(int[] nums) {
    int N = nums.length, count = 0, l = 0;
    while (l + nums[l] < N - 1) {
      int jumps = nums[l], maxDiff = Integer.MIN_VALUE, maxIdx = l;
      for (int r = l + 1; r <= Math.min(N - 1, l + nums[l]); r++) {
        jumps--;
        if (nums[r] - jumps > maxDiff) {
          maxDiff = nums[r] - jumps;
          maxIdx = r;
        }
      }
      l = maxIdx;
      count++;
    }
    return l == N - 1 ? count : count + 1;
  }
}
