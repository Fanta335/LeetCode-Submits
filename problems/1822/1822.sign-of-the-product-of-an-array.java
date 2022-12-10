/*
 * @lc app=leetcode id=1822 lang=java
 *
 * [1822] Sign of the Product of an Array
 */

// @lc code=start
class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for (int n : nums) {
            if (n == 0) {
                product = 0;
                break;
            } else if (n > 0) {
                product *= 1;
            } else {
                product *= -1;
            }
        }
        return signFunc(product);
    }

    private int signFunc(int product) {
        if (product > 0) {
            return 1;
        } else if (product < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
// @lc code=end

