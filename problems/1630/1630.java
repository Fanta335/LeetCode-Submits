import java.util.*;

class Solution {
  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    int m = l.length;
    List<Boolean> ans = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int left = l[i], right = r[i];
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();

      for (int j = left; j <= right; j++) {
        minHeap.offer(nums[j]);
      }

      int prev = minHeap.poll();
      int curr = minHeap.peek();
      int diff = curr - prev;

      prev = curr;
      minHeap.poll();

      while (!minHeap.isEmpty()) {
        curr = minHeap.peek();
        if (curr - prev != diff) {
          break;
        }

        prev = curr;
        minHeap.poll();
      }

      ans.add(minHeap.isEmpty());
    }

    return ans;
  }
}
