import java.util.*;

class WordsComparator implements Comparator<String> {
  @Override
  public int compare(String a, String b) {
    if (a.length() == b.length()) {
      for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == b.charAt(i)) {
          continue;
        }
        return a.charAt(i) - b.charAt(i);
      }
      return 0;
    } else {
      return a.length() - b.length();
    }
  }
}


class Solution {
  public int longestStrChain(String[] words) {
    WordsComparator comparator = new WordsComparator();
    Arrays.sort(words, comparator);
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      int currMax = 0;
      for (int i = 0; i < word.length(); i++) {
        String sub = word.substring(0, i) + word.substring(i + 1, word.length());
        if (map.containsKey(sub)) {
          currMax = Math.max(currMax, map.get(sub));
        }
      }
      map.put(word, currMax + 1);
    }
    int res = 0;
    for (int c : map.values()) {
      res = Math.max(res, c);
    }
    return res;
  }
}
