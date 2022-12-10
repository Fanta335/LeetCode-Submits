import java.util.Arrays;

/*
 * @lc app=leetcode id=1502 lang=java
 *
 * [1502] Can Make Arithmetic Progression From Sequence
 */

// @lc code=start
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = Math.abs(arr[0] - arr[1]);
        for (int i = 2; i < arr.length; i++) {
            if (diff != Math.abs(arr[i] - arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

