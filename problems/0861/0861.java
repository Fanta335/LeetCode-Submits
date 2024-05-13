class Solution {
  public int matrixScore(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] dp = new int[n];

    for (int i = 0; i < m; i++) {
      if (grid[i][0] == 0) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 0) {
            grid[i][j] = 1;
            dp[j]++;
          } else {
            grid[i][j] = 0;
          }
        }
      } else {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 1) {
            dp[j]++;
          }
        }
      }
    }

    for (int j = 1; j < n; j++) {
      if (dp[j] <= m / 2) {
        for (int i = 0; i < m; i++) {
          if (grid[i][j] == 0) {
            grid[i][j] = 1;
          } else {
            grid[i][j] = 0;
          }
        }
      }
    }

    int res = 0;

    for (int i = 0; i < m; i++) {
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < n; j++) {
        sb.append(grid[i][j]);
      }

      System.out.println(sb.toString());
      res += Integer.parseInt(sb.toString(), 2);
    }

    return res;
  }
}
