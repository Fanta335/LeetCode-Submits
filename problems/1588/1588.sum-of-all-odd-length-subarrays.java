/*
 * @lc app=leetcode id=1588 lang=java
 *
 * [1588] Sum of All Odd Length Subarrays
 */

// @lc code=start
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int N = arr.length;
        int len = 1;
        int sum = 0;
        int currSum = 0;
        while (len <= N) {
            currSum = 0;
            for (int i = 0; i < len; i++) {
                currSum += arr[i];
            }
            sum += currSum;
            for (int i = len; i < N; i++) {
                currSum = currSum - arr[i - len] + arr[i];
                sum += currSum;
            }
            len += 2;
        }
        return sum;
    }
}
// @lc code=end

