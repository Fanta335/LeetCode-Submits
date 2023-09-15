import java.util.*;

class Solution {
  public int minCostConnectPoints(int[][] points) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    int res = 0, connected = 1, i = 0, n = points.length;
    boolean[] visited = new boolean[n];

    while (connected < n) {
      visited[i] = true;

      for (int j = 1; j < n; j++) {
        if (!visited[j]) {
          minHeap.offer(new int[] {
              Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), j});
        }
      }

      while (visited[minHeap.peek()[1]]) {
        minHeap.poll();
      }

      int[] curr = minHeap.poll();
      res += curr[0];
      i = curr[1];
      connected++;
    }

    return res;
  }
}
