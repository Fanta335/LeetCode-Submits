/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int N = nums.length;
        if (N < 3) {
            return 0;
        }
        int count = 0;
        int len = 2;
        int diff = nums[1] - nums[0];
        for (int i = 2; i < N; i++) {
            if (diff == nums[i] - nums[i - 1] && len >= 2) {
                count += len - 2;
                len++;
            } else {
                diff = nums[i] - nums[i - 1];
                len = 2;
            }
        }
        return count;
    }
}
// @lc code=end

