/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 0, suffix = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            suffix = (suffix == 0 ? 1 : suffix) * nums[nums.length - 1 - i];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
// @lc code=end

