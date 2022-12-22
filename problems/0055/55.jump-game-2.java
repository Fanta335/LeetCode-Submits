/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            jumps = Math.max(jumps, nums[i]);
            if (jumps == 0) {
                return false;
            }
            jumps--;
        }
        return true;
    }
}
// @lc code=end

