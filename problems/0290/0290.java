import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] arr = s.split(" ");
    int N = pattern.length();
    if (arr.length != N) {
      return false;
    }
    Map<Character, String> mp = new HashMap<>();
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < N; i++) {
      char c = pattern.charAt(i);
      if (!mp.containsKey(c)) {
        if (seen.contains(arr[i])) {
          return false;
        }
        mp.put(c, arr[i]);
        seen.add(arr[i]);
      } else {
        if (!arr[i].equals(mp.get(c))) {
          return false;
        }
      }
    }
    return true;
  }
}
