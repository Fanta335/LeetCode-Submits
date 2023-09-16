import java.util.*;

class Solution {
  int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int minimumEffortPath(int[][] heights) {
    int n = heights.length, m = heights[0].length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int[] row : heights) {
      for (int cell : row) {
        min = Math.min(min, cell);
        max = Math.max(max, cell);
      }
    }
    int l = 0, r = max - min;
    while (l < r) {
      int mid = (l + r) / 2;
      Stack<int[]> stack = new Stack<>();
      boolean[][] visited = new boolean[n][m];
      stack.push(new int[] {0, 0});
      visited[0][0] = true;
      while (!stack.isEmpty()) {
        int[] curr = stack.pop();
        visited[curr[0]][curr[1]] = true;
        if (curr[0] == n && curr[1] == m) {
          break;
        }
        for (int[] dir : dirs) {
          int[] next = new int[] {curr[0] + dir[0], curr[1] + dir[1]};
          if (next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < m
              && !visited[next[0]][next[1]]
              && (Math.abs(heights[curr[0]][curr[1]] - heights[next[0]][next[1]]) <= mid)) {
            stack.push(next);
          }
        }
      }
      if (visited[n - 1][m - 1]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return l;
  }
}
