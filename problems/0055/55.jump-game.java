/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return false;
        }
        int i = 0;
        int count = 0;
        while (count >= 0) {
            if (i == N - 1) {
                return true;
            }
            count = Math.max(count, nums[i]);
            i++;
            count--;
        }
        return false;
    }
}
// @lc code=end

