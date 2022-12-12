/*
 * @lc app=leetcode id=1672 lang=java
 *
 * [1672] Richest Customer Wealth
 */

// @lc code=start
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int sum = 0;
        for (int[] acc : accounts) {
            sum = 0;
            for (int money : acc) {
                sum += money;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
// @lc code=end

