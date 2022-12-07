/*
 * @lc app=leetcode id=1523 lang=java
 *
 * [1523] Count Odd Numbers in an Interval Range
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        count += (high - low) / 2;
        if (low % 2 != 0 || high % 2 != 0) {
            count++;
        }
        return count;
    }
}
// @lc code=end

