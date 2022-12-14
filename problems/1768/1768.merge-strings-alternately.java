/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int shorter = 0;
        int longer = 0;
        if (word1.length() < word2.length()) {
            shorter = word1.length();
            longer = word2.length();
        } else {
            shorter = word2.length();
            longer = word1.length();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shorter; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word1.length() < word2.length()) {
            sb.append(word2.substring(shorter, longer));
        } else {
            sb.append(word1.substring(shorter, longer));
        }
        return sb.toString();
    }
}
// @lc code=end

