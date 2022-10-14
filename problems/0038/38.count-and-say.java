/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        return helper(n, "1");
    }

    private String helper(int n, String curr) {
        if (n == 1) {
            return curr;
        }
        int count = 1;
        char[] chars = curr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append(count);
                sb.append(chars[i - 1]);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(chars[chars.length - 1]);

        return helper(n - 1, sb.toString());
    }
}
// @lc code=end

