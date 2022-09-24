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
        int l = 0;
        int r = 2;
        while (l < N - 2) {
            if (r >= N || (nums[l + 1] - nums[l] != nums[r] - nums[r - 1])) {
                l++;
                r = l + 2;
                continue;
            }
            count++;
            r++;
        }
        return count;
    }
}
// @lc code=end

