import java.util.Arrays;

class Solution {
  public int maxSatisfaction(int[] satisfaction) {
    Arrays.sort(satisfaction);
    int n = satisfaction.length;
    int[][] dp = new int[n + 1][n + 2];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = Math.max(satisfaction[i] * j + dp[i + 1][j + 1], dp[i + 1][j]);
      }
    }
    return dp[0][1];
  }
}
