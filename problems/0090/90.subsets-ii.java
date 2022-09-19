import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, set, curr, 0);
        return new ArrayList<>(set);
    }

    private void helper(int[] nums, Set<List<Integer>> set, List<Integer> curr, int i) {
        set.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            helper(nums, set, curr, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

