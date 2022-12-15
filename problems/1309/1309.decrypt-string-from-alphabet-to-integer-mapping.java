/*
 * @lc app=leetcode id=1309 lang=java
 *
 * [1309] Decrypt String from Alphabet to Integer Mapping
 */

// @lc code=start
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 2 && (arr[i] == '1' || arr[i] == '2') && arr[i + 2] == '#') {
                res.append((char) ((arr[i] - '0') * 10 + arr[i + 1] - '1' + 'a'));
                i += 2;
            } else {
                res.append((char) (arr[i] - '1' + 'a'));
            }
        }
        return res.toString();
    }
}
// @lc code=end

