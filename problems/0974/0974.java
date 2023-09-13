import java.util.HashMap;
import java.util.Map;

class Solution {
  public int subarraysDivByK(int[] nums, int k) {
    int N = nums.length;
    int[] prefix = new int[N];
    prefix[0] = nums[0];
    for (int i = 1; i < N; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }
    int count = 0;
    Map<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < N; i++) {
      if (prefix[i] % k == 0) {
        count++;
      }
      if (mp.containsKey(prefix[i] - k)) {
        count += mp.get(prefix[i] - k);
      }
      mp.put(prefix[i], mp.getOrDefault(prefix[i], 0) + 1);
    }
    return count;
  }
}
