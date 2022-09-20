import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    private void helper(int[] candidates, int target, List<Integer> curr, List<List<Integer>> res, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            curr.add(candidates[i]);
            helper(candidates, target - candidates[i], curr, res, i);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

