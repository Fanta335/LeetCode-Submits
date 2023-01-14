import java.util.PriorityQueue;

class Solution {
  public long maxKelements(int[] nums, int k) {
    int N = nums.length;
    long sum = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer a, Integer b) -> b - a);
    for (int i = 0; i < N; i++) {
      maxHeap.offer(nums[i]);
    }
    while (k > 0) {
      int temp = maxHeap.poll();
      sum += temp;
      maxHeap.offer((int) Math.ceil(temp / 3.0));
      k--;
    }
    return sum;
  }
}

