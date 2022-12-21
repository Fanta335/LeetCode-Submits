/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(a + nums[i], b);
            a = b;
            b = sum;
        }
        return sum;
    }
}
// @lc code=end

