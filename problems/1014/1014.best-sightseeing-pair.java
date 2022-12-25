/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0, prevBestIdx = 0;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, values[prevBestIdx] + prevBestIdx + values[i] - i);
            if (values[prevBestIdx] + prevBestIdx < values[i] + i) {
                prevBestIdx = i;
            }
        }
        return res;
    }
}
// @lc code=end

