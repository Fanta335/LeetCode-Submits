/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return solve(dp, m - 1, n - 1);
    }

    private int solve(int[][] dp, int y, int x) {
        if (y == 0 || x == 0) {
            return 1;
        }
        if (dp[y][x] != 0) {
            return dp[y][x];
        }
        dp[y][x] = solve(dp, y - 1, x) + solve(dp, y, x - 1);
        return dp[y][x];
    }
}
// @lc code=end

