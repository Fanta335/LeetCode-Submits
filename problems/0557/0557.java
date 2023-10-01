class Solution {
  public String reverseWords(String s) {
    StringBuilder res = new StringBuilder(), word = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == ' ') {
        res.append(word.append(ch).toString());
        word.delete(0, word.length());
      } else {
        word.insert(0, ch);
      }
    }
    res.append(word.toString());
    return res.toString();
  }
}
