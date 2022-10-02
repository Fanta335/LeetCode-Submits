/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        int res = nums[0];
        int l = 0, r = 0;
        for (int i = 0; i < N; i++) {
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[N - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
// @lc code=end

