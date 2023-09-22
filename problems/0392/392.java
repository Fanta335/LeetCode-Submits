class Solution {
  public boolean isSubsequence(String s, String t) {
    if (s.length() > t.length()) {
      return false;
    }
    if (s.length() == 0) {
      return true;
    }
    int ps = 0, pt = 0;
    while (ps < s.length() && pt < t.length()) {
      if (s.charAt(ps) == t.charAt(pt)) {
        ps++;
      }
      pt++;
    }
    return ps == s.length();
  }
}
