import java.util.*;

class Solution {
  public int maxVowels(String s, int k) {
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');

    int count = 0;
    for (int i = 0; i < k; i++) {
      if (vowels.contains(s.charAt(i))) {
        count++;
      }
    }
    int res = count;
    for (int i = k; i < s.length(); i++) {
      if (vowels.contains(s.charAt(i))) {
        count++;
      }
      if (vowels.contains(s.charAt(i - k))) {
        count--;
      }
      res = Math.max(res, count);
    }
    return res;
  }
}
