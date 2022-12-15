/*
 * @lc app=leetcode id=709 lang=java
 *
 * [709] To Lower Case
 */

// @lc code=start
class Solution {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('A' <= arr[i] && arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] - 'A' + 'a');
            }
        }
        return new String(arr);
    }
}
// @lc code=end

