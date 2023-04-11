class Solution {
  public String removeStars(String s) {
    int stars = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (ch == '*') {
        stars++;
      } else if (stars == 0) {
        sb.append(ch);
      } else {
        stars--;
      }
    }
    return sb.reverse().toString();
  }
}
