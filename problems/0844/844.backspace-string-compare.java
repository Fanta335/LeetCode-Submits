/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

