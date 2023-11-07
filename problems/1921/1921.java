import java.util.*;

class Solution {
  public int eliminateMaximum(int[] dist, int[] speed) {
    int N = dist.length;
    PriorityQueue<Double> minHeap = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      double minutesToReach = (double) dist[i] / speed[i];
      minHeap.offer(minutesToReach);
    }

    int count = 0;

    while (!minHeap.isEmpty()) {
      double curr = minHeap.poll();

      if (curr <= count) {
        return count;
      }

      count++;
    }


    return count;
  }
}

