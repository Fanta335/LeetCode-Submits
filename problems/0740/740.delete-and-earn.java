/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] counts = new int[10001];

        for (int n : nums) {
            counts[n]++;
        }

        int a = 0, b = 0;
        for (int i = 1; i < counts.length; i++) {
            int sum = Math.max(a + i * counts[i], b);
            a = b;
            b = sum;
        }

        return b;
    }
}
// @lc code=end

