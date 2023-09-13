class Solution {
  public int partitionString(String s) {
    int res = 1, l = 0, r = 0;
    boolean[] cache = new boolean[26];
    while (r < s.length()) {
      if (cache[s.charAt(r) - 'a']) {
        res++;
        while (l < r) {
          cache[s.charAt(l++) - 'a'] = false;
        }
      }
      cache[s.charAt(r++) - 'a'] = true;
    }
    return res;
  }
}
