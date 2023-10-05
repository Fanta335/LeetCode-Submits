import java.util.*;

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num : nums) {
      if (!counts.containsKey(num)) {
        counts.put(num, 0);
      }
      counts.put(num, counts.get(num) + 1);
    }
    List<Integer> res = new ArrayList<>();
    for (int key : counts.keySet()) {
      if (counts.get(key) > nums.length / 3) {
        res.add(key);
      }
    }
    return res;
  }
}
