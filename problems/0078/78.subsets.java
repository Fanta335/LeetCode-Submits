import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, res, curr, 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int i) {
        res.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(nums, res, curr, j+1);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

