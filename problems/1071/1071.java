class Solution {
  public String gcdOfStrings(String str1, String str2) {
    if (str1.length() < str2.length()) {
      return gcdOfStrings(str2, str1);
    }
    for (int i = str2.length(); i >= 0; i--) {
      String curr = str2.substring(0, i);
      if (str1.replace(curr, "").equals("") && str2.replace(curr, "").equals("")) {
        return curr;
      }
    }
    return "";
  }
}
