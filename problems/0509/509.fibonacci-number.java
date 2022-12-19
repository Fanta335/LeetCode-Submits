/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int n1 = 0, n2 = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }
}
// @lc code=end

