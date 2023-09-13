import java.util.HashMap;
import java.util.Map;

class Solution {
  public int minimumRounds(int[] tasks) {
    Map<Integer, Integer> mp = new HashMap<>();
    for (int t : tasks) {
      mp.put(t, mp.getOrDefault(t, 0) + 1);
    }
    int count = 0;
    for (int c : mp.values()) {
      if (c == 1) {
        return -1;
      }
      count += c % 3 > 0 ? c / 3 + 1 : c / 3;
    }
    return count;
  }
}
