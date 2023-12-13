class Solution {
  public int numSpecial(int[][] mat) {
    int n = mat.length, m = mat[0].length;
    int[] counts = new int[m];

    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < m; j++) {
        sum += mat[i][j];
      }
      if (sum == 1) {
        sum = 0;
      }
      for (int j = 0; j < m; j++) {
        counts[j] += mat[i][j] == 1 ? (mat[i][j] + sum) : mat[i][j];
      }
    }

    int ans = 0;

    for (int count : counts) {
      if (count == 1) {
        ans++;
      }
    }

    return ans;
  }
}
