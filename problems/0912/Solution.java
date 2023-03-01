import java.util.PriorityQueue;

class Solution {
  public int[] sortArray(int[] nums) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int n : nums) {
      minHeap.add(n);
    }
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = minHeap.poll();
    }
    return res;
  }
}
