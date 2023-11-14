class Solution {
  public int countPalindromicSubsequence(String s) {
    int n = s.length();
    int[][] ids = new int[26][2];

    for (int[] id : ids) {
      id[0] = -1;
      id[1] = -1;
    }

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      int[] id = ids[ch - 'a'];
      if (id[0] == -1) {
        id[0] = i;
      } else {
        id[1] = i;
      }
    }

    int count = 0;

    for (int i = 0; i < ids.length; i++) {
      int[] id = ids[i];
      int minId = id[0], maxId = id[1];
      boolean[] seen = new boolean[26];

      for (int j = minId + 1; j < maxId; j++) {
        char midChar = s.charAt(j);
        if (!seen[midChar - 'a']) {
          count++;
          seen[midChar - 'a'] = true;
        }
      }
    }

    return count;
  }
}
