/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] list = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            list[i] = new StringBuilder();
        }
        int row = 0;
        boolean reverse = false;
        for (char ch : s.toCharArray()) {
            list[row].append(ch);

            if (row == numRows - 1) {
                reverse = true;
            } else if (row == 0) {
                reverse = false;
            }

            if (reverse) {
                row--;
            } else {
                row++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }
}
// @lc code=end

