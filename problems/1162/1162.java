import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int maxDistance(int[][] grid) {
    int N = grid.length;
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 1) {
          q.offer(new int[] {i, j, 0});
        }
      }
    }
    if (q.size() == 0 || q.size() == N * N) {
      return -1;
    }
    int maxDist = 0;
    while (!q.isEmpty()) {
      int[] pos = q.poll();
      int x = pos[0], y = pos[1], dist = pos[2];
      maxDist = Math.max(maxDist, dist);
      if (x > 0 && grid[x - 1][y] == 0) {
        q.offer(new int[] {x - 1, y, dist + 1});
        grid[x - 1][y] = 1;
      }
      if (x < N - 1 && grid[x + 1][y] == 0) {
        q.offer(new int[] {x + 1, y, dist + 1});
        grid[x + 1][y] = 1;
      }
      if (y > 0 && grid[x][y - 1] == 0) {
        q.offer(new int[] {x, y - 1, dist + 1});
        grid[x][y - 1] = 1;
      }
      if (y < N - 1 && grid[x][y + 1] == 0) {
        q.offer(new int[] {x, y + 1, dist + 1});
        grid[x][y + 1] = 1;
      }
    }
    return maxDist;
  }
}
