/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0], b = cost[1], sum = 0;
        for (int i = 2; i < cost.length; i++) {
            sum = Math.min(a, b) + cost[i];
            a = b;
            b = sum;
        }
        return Math.min(a, b);
    }
}
// @lc code=end

