class Solution {
  public char findTheDifference(String s, String t) {
    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counts[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      if (counts[t.charAt(i) - 'a']-- == 0) {
        return t.charAt(i);
      }
    }
    return 'a';
  }
}
