/*
 * @lc app=leetcode id=1567 lang=java
 *
 * [1567] Maximum Length of Subarray With Positive Product
 */

// @lc code=start
class Solution {
    public int getMaxLen(int[] nums) {
        int l = 0, r = 0, lLen = 0, rLen = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (l == 0) {
                l = nums[i];
                lLen = 1;
            } else {
                if (nums[i] > 0) {
                    l *= 1;
                } else if (nums[i] < 0) {
                    l *= -1;
                } else {
                    l = 0;
                }
                lLen++;
            }

            if (r == 0) {
                r = nums[nums.length - 1 - i];
                rLen = 1;
            } else {
                if (nums[nums.length - 1 - i] > 0) {
                    r *= 1;
                } else if (nums[nums.length - 1 - i] < 0) {
                    r *= -1;
                } else {
                    r = 0;
                }
                rLen++;
            }

            maxLen = Math.max(maxLen, Math.max((l > 0 ? lLen : 0), (r > 0 ? rLen : 0)));
        }
        return maxLen;
    }
}
// @lc code=end

