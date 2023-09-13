class Solution {
  public boolean makeStringsEqual(String s, String target) {
    int N = s.length();
    int x = 0, y = 0;
    for (int i = 0; i < N; i++) {
      if (s.charAt(i) == '1') {
        x++;
      }
      if (target.charAt(i) == '1') {
        y++;
      }
    }

    if (y == 0) {
      return s.equals(target);
    }
    return x > 0;
  }
}
