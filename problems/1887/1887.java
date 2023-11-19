import java.util.*;

class Solution {
  public int reductionOperations(int[] nums) {
    int n = nums.length, count = 0;
    Arrays.sort(nums);

    for (int r = n - 1; r >= 0; r--) {
      for (int l = r - 1; l >= 0; l--) {
        if (nums[l] == nums[r]) {
          continue;
        }
        count += n - 1 - l;
        r = l;
        break;
      }
    }

    return count;
  }
}
