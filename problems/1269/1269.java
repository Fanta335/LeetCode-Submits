class Solution {
  public int numWays(int steps, int arrLen) {
    int mod = (int) 1e9 + 7;

    int[][] dp = new int[2][arrLen];
    dp[0][0] = 1;

    for (int step = 1; step <= steps; step++) {
      int current = step % 2;
      int previous = 1 - current;

      for (int pos = 0; pos < arrLen; pos++) {
        dp[current][pos] = dp[previous][pos];

        if (pos > 0) {
          dp[current][pos] = (dp[current][pos] + dp[previous][pos - 1]) % mod;
        }

        if (pos < arrLen - 1) {
          dp[current][pos] = (dp[current][pos] + dp[previous][pos + 1]) % mod;
        }
      }
    }

    return dp[steps % 2][0];
  }
}
