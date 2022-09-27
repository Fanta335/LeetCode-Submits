import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int count = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nums[i] <= dp[j]) {
                    dp[j] = nums[i];
                    count = Math.max(count, j + 1);
                    break;
                }
            }
        }
        return count;
    }
}
// @lc code=end

