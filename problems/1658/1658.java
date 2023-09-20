import java.util.*;

class Solution {
  public int minOperations(int[] nums, int x) {
    int n = nums.length, suffixSum = 0;
    int[] prefix = new int[n + 1];
    Map<Integer, Integer> suffixMap = new HashMap<>();
    suffixMap.put(0, 0);
    for (int i = 1; i <= n; i++) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
      suffixSum += nums[n - i];
      suffixMap.put(suffixSum, i);
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i <= n; i++) {
      int remainder = x - prefix[i];
      if (suffixMap.containsKey(remainder) && i <= n - suffixMap.get(remainder)) {
        res = Math.min(res, i + suffixMap.get(remainder));
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
