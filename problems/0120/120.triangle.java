import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = triangle.get(N - 1).get(i);
        }
        for (int r = N - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c], dp[c + 1]);
            }
        }

        return dp[0];
    }
}
// @lc code=end

