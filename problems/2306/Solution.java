import java.util.HashSet;
import java.util.Set;

class Solution {
  public long distinctNames(String[] ideas) {
    long res = 0;
    Set<String>[] initialGroup = new HashSet[26];
    for (String s : ideas) {
      if (initialGroup[s.charAt(0) - 'a'] == null) {
        initialGroup[s.charAt(0) - 'a'] = new HashSet<>();
      }
      initialGroup[s.charAt(0) - 'a'].add(s.substring(1));
    }
    for (int i = 0; i < 26; i++) {
      for (int j = i + 1; j < 26; j++) {
        Set<String> g1 = initialGroup[i], g2 = initialGroup[j];
        if (g1 == null || g2 == null) {
          continue;
        }
        long sameSuffixCount = 0;
        for (String s : g1) {
          if (g2.contains(s)) {
            sameSuffixCount++;
          }
        }
        res += 2 * (g1.size() - sameSuffixCount) * (g2.size() - sameSuffixCount);
      }
    }
    return res;
  }
}

