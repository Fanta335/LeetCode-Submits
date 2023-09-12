import java.util.*;

class Solution {
  public int minDeletions(String s) {
    int res = 0;
    int[] counts = new int[26];
    for (char c : s.toCharArray()) {
      counts[c - 'a']++;
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < counts.length; i++) {
      int count = counts[i];
      if (count == 0) {
        continue;
      }
      if (set.contains(count)) {
        for (int j = count - 1; j >= 0; j--) {
          if (!set.contains(j)) {
            res += count - j;
            if (j != 0) {
              set.add(j);
            }
            break;
          }
        }
      } else {
        set.add(count);
      }
    }

    return res;
  }
}
