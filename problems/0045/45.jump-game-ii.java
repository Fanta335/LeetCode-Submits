/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int maxReachable = 0;
        int lastJumpedPos = 0;
        int jumps = 0;
        while (lastJumpedPos < nums.length - 1) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == lastJumpedPos) {
                lastJumpedPos = maxReachable;
                jumps++;
            }
            i++;
        }
        return jumps;
    }
}
// @lc code=end

