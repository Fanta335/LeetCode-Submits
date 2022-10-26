/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int idx = 0;
        for (char ch : t.toCharArray()) {
            if (ch == s.charAt(idx)) {
                idx++;
            }
            if (idx == s.length()) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

