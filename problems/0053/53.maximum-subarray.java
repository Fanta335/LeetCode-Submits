/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] >= 0) {
                sum += nums[i];
                res = Math.max(res, sum);
            } else {
                sum = 0;
                res = Math.max(res, nums[i]);
            }
        }

        return res;
    }
}
// @lc code=end

