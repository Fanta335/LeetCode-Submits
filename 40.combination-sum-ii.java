import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> curr,
            int start) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            helper(nums, target - nums[i], res, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

