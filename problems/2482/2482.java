class Solution {
  public int[][] onesMinusZeros(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int[] row = new int[n], col = new int[m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          row[i]++;
          col[j]++;
        } else {
          row[i]--;
          col[j]--;
        }
      }
    }

    int[][] ans = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ans[i][j] = row[i] + col[j];
      }
    }
    return ans;
  }
}
