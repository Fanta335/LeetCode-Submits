class Solution {
  public int findMinimumOperations(String s1, String s2, String s3) {
    int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
    int minLen = Math.min(l1, Math.min(l2, l3));
    for (int i = 0; i < minLen; i++) {
      char c1 = s1.charAt(i), c2 = s2.charAt(i), c3 = s3.charAt(i);
      if (c1 == c2 && c1 == c3) {
        continue;
      } else {
        if (i < 1) {
          return -1;
        }
        minLen = i;
        break;
      }
    }
    return (l1 + l2 + l3) - minLen * 3;
  }
}
