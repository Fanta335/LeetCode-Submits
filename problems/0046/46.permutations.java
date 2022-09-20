import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        helper(nums, res, curr, set);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, Set<Integer> set) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!set.contains(j)) {
                curr.add(nums[j]);
                set.add(j);
                helper(nums, res, curr, set);
                curr.remove(curr.size() - 1);
                set.remove(j);
            }
        }
    }
}
// @lc code=end

