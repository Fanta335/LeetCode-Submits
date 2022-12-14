/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        counts[t.charAt(t.length() - 1) - 'a']--;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] < 0) {
                int ascii = 'a' - '0' + i;
                return (char) ascii;
            }
        }
        return 'a';
    }
}
// @lc code=end

