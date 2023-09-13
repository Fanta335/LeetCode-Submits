import java.util.*;

class Solution {
  int[][] dirs = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
      return -1;
    }
    boolean[][] visited = new boolean[n][n];
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {0, 0, 1});
    visited[0][0] = true;
    while (!q.isEmpty()) {
      int[] currPos = q.poll();
      if (currPos[0] == n - 1 && currPos[1] == n - 1) {
        return currPos[2];
      }
      for (int[] dir : dirs) {
        int[] nextPos = new int[] {currPos[0] + dir[0], currPos[1] + dir[1]};
        if (nextPos[0] < 0 || nextPos[0] >= n || nextPos[1] < 0 || nextPos[1] >= n
            || grid[nextPos[0]][nextPos[1]] == 1 || visited[nextPos[0]][nextPos[1]]) {
          continue;
        }
        visited[nextPos[0]][nextPos[1]] = true;
        q.offer(new int[] {nextPos[0], nextPos[1], currPos[2] + 1});
      }
    }

    return -1;
  }
}
