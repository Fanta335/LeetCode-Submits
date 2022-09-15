/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[l++];
                }
                min = Math.min(min, r - l + 2);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// @lc code=end

