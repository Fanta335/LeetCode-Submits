class Solution {
  public boolean detectCapitalUse(String word) {
    int idx = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) - 'a' < 0) {
        idx++;
      }
    }
    return idx == 0 || idx == word.length() || (word.charAt(0) - 'a' < 0 && idx == 1);
  }
}
