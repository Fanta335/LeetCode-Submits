/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        int N = s.length();
        int[] f0 = new int[N + 1];
        int[] f1 = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            f0[i] += f0[i - 1];
            if (s.charAt(i - 1) == '1') {
                f0[i]++;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            f1[i] += f1[i + 1];
            if (s.charAt(i) == '0') {
                f1[i]++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            res = Math.min(res, f0[i] + f1[i]);
        }
        return res;
    }
}
// @lc code=end

