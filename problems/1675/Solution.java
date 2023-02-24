import java.util.*;

class Solution {
  public int minimumDeviation(int[] nums) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((Integer a, Integer b) -> a - b);
    int min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
    for (int n : nums) {
      if (n % 2 == 1) {
        n *= 2;
      }
      minHeap.add(-n);
      min = Math.min(min, n);
    }
    while (true) {
      int n = -minHeap.poll();
      res = Math.min(res, n - min);
      if (n % 2 == 1) {
        break;
      }
      min = Math.min(min, n / 2);
      minHeap.add(-n / 2);
    }
    return res;
  }
}
