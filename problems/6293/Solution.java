import java.util.HashSet;
import java.util.Set;

class Solution {
  public long countGood(int[] nums, int k) {
    int N = nums.length;
    int res = 0;
    for (int start = 0; start < N - 1; start++) {
      for (int end = 1; end < N; end++) {
        int count = 0;
        for (int i = start; i < end; i++) {
          for (int j = i + 1; j <= end; j++) {
            if (nums[i] == nums[j]) {
              count++;
            }
          }
          if (count == k) {
            res++;
            break;
          }
        }
      }
    }

    return res;
  }
}
