/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int count = 0;
        int prod = 1;
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            prod *= nums[fast];
            while (prod >= k) {
                prod /= nums[slow++];
            }
            count += fast - slow + 1;
            fast++;
        }

        return count;
    }
}
// @lc code=end

