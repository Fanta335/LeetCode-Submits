class Solution {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    int n1 = word1.length, n2 = word2.length;
    int i1 = 0, i2 = 0, j1 = 0, j2 = 0;

    while (i1 < n1 && i2 < n2) {
      String w1 = word1[i1], w2 = word2[i2];

      if (w1.charAt(j1) != w2.charAt(j2)) {
        return false;
      }

      j1++;
      j2++;

      if (j1 == w1.length()) {
        j1 = 0;
        i1++;
      }

      if (j2 == w2.length()) {
        j2 = 0;
        i2++;
      }
    }

    return i1 == n1 && i2 == n2;
  }
}
