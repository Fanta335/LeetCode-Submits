import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if (s.length() < p.length()) {
      return res;
    }
    int[] freq = new int[26];
    int[] curr = new int[26];
    for (int i = 0; i < p.length(); i++) {
      freq[p.charAt(i) - 'a']++;
      curr[s.charAt(i) - 'a']++;
    }
    for (int i = p.length(); i < s.length(); i++) {
      if (Arrays.equals(freq, curr)) {
        res.add(i - p.length());
      }
      curr[s.charAt(i - p.length()) - 'a']--;
      curr[s.charAt(i) - 'a']++;
    }
    if (Arrays.equals(freq, curr)) {
      res.add(s.length() - p.length());
    }
    return res;
  }
}
