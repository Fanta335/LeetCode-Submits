/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int N = s.length();
        int[] cache = new int[26];
        for (int i = 0; i < N; i++) {
            cache[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < N; i++) {
            if (cache[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

