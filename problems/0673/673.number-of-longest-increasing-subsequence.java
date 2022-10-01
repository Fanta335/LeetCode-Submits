/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int maxLen = 0;
        int[] len = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (maxLen == len[i]) {
                res += cnt[i];
            }
            if (maxLen < len[i]) {
                maxLen = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
// @lc code=end

