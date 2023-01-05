/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int[][] dp = new int[N][N];
        for (int x = 0; x < N; x++) {
            dp[0][x] = matrix[0][x];
        }

        for (int y = 1; y < N; y++) {
            dp[y][0] = matrix[y][0] + Math.min(dp[y - 1][0], dp[y - 1][1]);
            for (int x = 1; x < N - 1; x++) {
                dp[y][x] = matrix[y][x]
                        + Math.min(dp[y - 1][x - 1], Math.min(dp[y - 1][x], dp[y - 1][x + 1]));
            }
            dp[y][N - 1] = matrix[y][N - 1] + Math.min(dp[y - 1][N - 2], dp[y - 1][N - 1]);
        }


        int res = Integer.MAX_VALUE;
        for (int n : dp[N - 1]) {
            res = Math.min(res, n);
        }
        return res;
    }
}
// @lc code=end

