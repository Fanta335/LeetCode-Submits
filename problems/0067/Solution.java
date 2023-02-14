class Solution {
  public String addBinary(String a, String b) {
    if (a.length() < b.length()) {
      return addBinary(b, a);
    }
    StringBuilder res = new StringBuilder();
    int carry = 0, i = a.length() - 1, j = b.length() - 1;
    while (j >= 0) {
      char ca = a.charAt(i--), cb = b.charAt(j--);
      int sum = ca - '0' + cb - '0' + carry;
      if (sum > 1) {
        carry = 1;
      } else {
        carry = 0;
      }
      res.insert(0, sum % 2);
    }
    while (i >= 0) {
      char ca = a.charAt(i--);
      int sum = ca - '0' + carry;
      if (sum > 1) {
        carry = 1;
      } else {
        carry = 0;
      }
      res.insert(0, sum % 2);
    }
    if (carry == 1) {
      res.insert(0, 1);
    }
    return res.toString();
  }
}
