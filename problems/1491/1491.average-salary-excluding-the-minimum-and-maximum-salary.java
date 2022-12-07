/*
 * @lc app=leetcode id=1491 lang=java
 *
 * [1491] Average Salary Excluding the Minimum and Maximum Salary
 */

// @lc code=start
class Solution {
    public double average(int[] salary) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = 0;
        for (int sal : salary) {
            sum += sal;
            max = Math.max(max, sal);
            min = Math.min(min, sal);
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }
}
// @lc code=end

