class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    StringBuilder[] list = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      list[i] = new StringBuilder();
    }
    boolean reverse = false;
    int currRow = 0;
    for (int i = 0; i < s.length(); i++) {
      list[currRow].append(s.charAt(i));
      currRow = reverse ? currRow - 1 : currRow + 1;
      if (currRow == 0 || currRow == numRows - 1) {
        reverse = !reverse;
      }
    }
    StringBuilder res = new StringBuilder();
    for (StringBuilder sb : list) {
      res.append(sb);
    }
    return res.toString();
  }
}
