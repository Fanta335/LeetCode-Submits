import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        Set<List<Integer>> resSet = new HashSet<>();
        Set<Integer> currSet = new HashSet<>();
        helper(nums, curr, resSet, currSet);
        return new ArrayList<>(resSet);
    }

    private void helper(int[] nums, List<Integer> curr, Set<List<Integer>> resSet,
            Set<Integer> currSet) {
        if (curr.size() == nums.length) {
            resSet.add(new ArrayList<>(curr));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!currSet.contains(j)) {
                curr.add(nums[j]);
                currSet.add(j);
                helper(nums, curr, resSet, currSet);
                curr.remove(curr.size() - 1);
                currSet.remove(j);
            }
        }
    }
}
// @lc code=end

