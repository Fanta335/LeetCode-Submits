/*
 * @lc app=leetcode id=1281 lang=java
 *
 * [1281] Subtract the Product and Sum of Digits of an Integer
 */

// @lc code=start
class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, prod = 1;
        while (n >= 1) {
            int curr = n % 10;
            n /= 10;
            sum += curr;
            prod *= curr;
        }
        return prod - sum;
    }
}
// @lc code=end

