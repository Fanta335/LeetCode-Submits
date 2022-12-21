/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }
        int a = nums[0], b = nums[0];
        for (int i = 2; i < N; i++) {
            int sum = Math.max(a + nums[i], b);
            a = b;
            b = sum;
        }
        int robFirst = b;
        a = 0;
        b = nums[1];
        for (int i = 2; i < N; i++) {
            int sum = Math.max(a + nums[i], b);
            a = b;
            b = sum;
        }
        int robSecond = b;
        return Math.max(robFirst, robSecond);
    }
}
// @lc code=end

