/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        int idx = 0;
        while (true) {
            for (int i = 0; i < words.length; i++) {
                if ( map[words[i].charAt(idx) - 'a'] > map[words[i + 1].charAt(idx) - 'a']) {
                    return false;
                } else if (map[words[i].charAt(idx) - 'a'] == map[words[i + 1].charAt(idx) - 'a']) {
                    if (words[i].length() > words[i + 1].length()) {
                        return false;
                    }
                    continue;
                } else {

                }
            }
        }
        return true;
    }
}
// @lc code=end

