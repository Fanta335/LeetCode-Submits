import java.util.PriorityQueue;

class Solution {
  public int maxIceCream(int[] costs, int coins) {
    PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>((Integer a, Integer b) -> Integer.compare(b, a));
    for (int c : costs) {
      if (coins >= c) {
        maxHeap.add(c);
        coins -= c;
      } else {
        if (!maxHeap.isEmpty()) {
          int currMax = maxHeap.peek();
          if (currMax > c) {
            maxHeap.poll();
            maxHeap.offer(c);
            coins += currMax - c;
          }
        }
      }
    }
    return maxHeap.size();
  }
}
