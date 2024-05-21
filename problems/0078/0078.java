import java.util.*;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    helper(nums, res, new ArrayList<>(), 0);

    return res;
  }

  private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, int idx) {
    res.add(new ArrayList<>(curr));

    for (int i = idx; i < nums.length; i++) {
      curr.add(nums[i]);
      helper(nums, res, curr, i + 1);
      curr.remove(curr.size() - 1);
    }
  }
}
