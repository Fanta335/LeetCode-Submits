import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currNum = n;
                int currStreak = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                max = Math.max(max, currStreak);
            }
        }
        return max;
    }
}
// @lc code=end

