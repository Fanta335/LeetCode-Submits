import java.util.*;

class Solution {
  int count;

  public int beautifulSubsets(int[] nums, int k) {
    Arrays.sort(nums);

    count = 0;

    helper(nums, 0, k, new HashMap<>());

    return count;
  }

  private void helper(int[] nums, int i, int k, Map<Integer, Integer> curr) {
    if (i == nums.length) {
      return;
    }

    for (int j = i; j < nums.length; j++) {
      if (!curr.containsKey(nums[j] - k)) {
        count++;
        curr.put(nums[j], curr.getOrDefault(nums[j], 0) + 1);
        helper(nums, j + 1, k, curr);
        if (curr.get(nums[j]) == 1) {
          curr.remove(nums[j]);
        } else {
          curr.put(nums[j], curr.get(nums[j]) - 1);
        }
      }
    }
  }
}
