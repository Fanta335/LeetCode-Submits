/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, maxPrice = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            res = Math.max(res, maxPrice - prices[i]);
        }
        return res;
    }
}
// @lc code=end

