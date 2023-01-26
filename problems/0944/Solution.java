class Solution {
  public int minDeletionSize(String[] strs) {
    int count = 0;
    for (int i = 0; i < strs[0].length(); i++) {
      char curr = 'a';
      for (String s : strs) {
        if (s.charAt(i) - curr < 0) {
          count++;
          break;
        }
        curr = s.charAt(i);
      }
    }
    return count;
  }
}
