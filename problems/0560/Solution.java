class Solution {
  public int subarraySum(int[] nums, int k) {
    int N = nums.length;
    int[] pre = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      pre[i] = pre[i - 1] + nums[i - 1];
    }
    int count = 0;
    for (int l = 1; l <= N; l++) {
      for (int r = l; r <= N; r++) {
        int sum = pre[r] - pre[l - 1];
        if (sum == k) {
          count++;
        }
      }
    }
    return count;
  }
}
