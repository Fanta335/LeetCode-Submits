import java.util.*;

class Solution {
  private final int mod = (int) 1e9 + 7;

  public int countNicePairs(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> counts = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int diff = nums[i] - reverseNum(nums[i]);
      counts.put(diff, counts.getOrDefault(diff, 0) + 1);
    }

    long ans = 0;

    for (int val : counts.values()) {
      ans += getCombinations((long) val) % mod;
    }

    return (int) ans % mod;
  }

  private int reverseNum(int num) {
    int res = 0;

    while (num > 0) {
      int curr = num % 10;
      res = res * 10 + curr;
      num = num / 10;
    }

    return res;
  }

  private long getCombinations(long num) {
    return num * (num - 1) / 2;
  }
}
