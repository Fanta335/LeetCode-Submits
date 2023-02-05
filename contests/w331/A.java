import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  public long pickGifts(int[] gifts, int k) {
    long res = 0;
    PriorityQueue<Long> maxHeap = new PriorityQueue<>(gifts.length, Collections.reverseOrder());
    for (int g : gifts) {
      maxHeap.offer((long) g);
    }
    for (int i = 0; i < k; i++) {
      long curr = maxHeap.peek();
      curr = (long) Math.sqrt(curr);
      maxHeap.poll();
      maxHeap.offer(curr);
    }
    while (!maxHeap.isEmpty()) {
      res += maxHeap.peek();
      maxHeap.poll();
    }
    return res;
  }
}
