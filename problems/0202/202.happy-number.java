import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int curr = n;
        while (!set.contains(curr)) {
            if (curr == 1) {
                return true;
            }
            set.add(curr);
            int sum = 0;
            while (curr >= 1) {
                sum += curr % 10 * curr % 10;
                curr /= 10;
            }
            curr = sum;
        }
        return false;
    }
}
// @lc code=end

