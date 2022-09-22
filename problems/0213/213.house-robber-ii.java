import java.util.Arrays;

/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }
        if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int[] totals = new int[N];
        totals[0] = nums[0];
        totals[2] = nums[0] + nums[2];
        // 0 start
        for (int i = 3; i < N - 1; i++) {
            totals[i] = nums[i] + Math.max(totals[i - 2], totals[i - 3]);
        }
        max = Math.max(totals[N - 2], totals[N - 3]);

        // 1 start
        Arrays.fill(totals, 0);
        totals[1] = nums[1];
        totals[2] = nums[2];
        for (int i = 3; i < N; i++) {
            totals[i] = nums[i] + Math.max(totals[i - 2], totals[i - 3]);
        }
        return Math.max(max, Math.max(totals[N - 1], totals[N - 2]));
    }
}
// @lc code=end

