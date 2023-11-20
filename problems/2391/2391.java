import java.util.*;

class Solution {
  public int garbageCollection(String[] garbage, int[] travel) {
    int n = garbage.length, ans = 0;
    Set<Character> set = new HashSet<>();

    for (int i = n - 1; i >= 0; i--) {
      String currGarbage = garbage[i];

      for (int j = 0; j < currGarbage.length(); j++) {
        char ch = currGarbage.charAt(j);
        if (!set.contains(ch)) {
          set.add(ch);
        }
      }

      ans += currGarbage.length();
      ans += i > 0 ? set.size() * travel[i - 1] : 0;
    }

    return ans;
  }
}
