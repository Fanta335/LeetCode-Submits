class Solution {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    dp[1][1] = 1;
    for (int y = 1; y <= m; y++) {
      for (int x = 1; x <= n; x++) {
        dp[y][x] += dp[y - 1][x] + dp[y][x - 1];
      }
    }

    return dp[m][n];
  }
}
