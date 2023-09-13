import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  int N;
  int[] nums;

  private void dfs(Set<List<Integer>> set, List<Integer> curr, int idx) {
    for (int i = idx; i < N; i++) {
      if (curr.size() == 0 || curr.get(curr.size() - 1) <= nums[i]) {
        curr.add(nums[i]);
        if (curr.size() > 1) {
          set.add(new ArrayList<>(curr));
        }
        dfs(set, curr, i + 1);
        curr.remove(curr.size() - 1);
      }
    }
  }

  public List<List<Integer>> findSubsequences(int[] nums) {
    this.nums = nums;
    this.N = nums.length;
    Set<List<Integer>> set = new HashSet<>();
    dfs(set, new ArrayList<>(), 0);
    return new ArrayList<>(set);
  }
}
