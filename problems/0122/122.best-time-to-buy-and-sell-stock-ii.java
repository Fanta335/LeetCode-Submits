/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, buy = Integer.MAX_VALUE, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i]);
            if (sell - buy > 0) {
                res += sell - buy;
                buy = Integer.MAX_VALUE;
                sell = 0;
            }
        }
        return res;
    }
}
// @lc code=end

