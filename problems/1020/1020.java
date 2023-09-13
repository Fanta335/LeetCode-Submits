import java.util.*;

class Solution {
  int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private int bfs(int[][] grid, boolean[][] visited, int r, int c) {
    int area = 0;
    boolean isOnBoundary = false;
    Queue<int[]> q = new LinkedList<>();
    visited[r][c] = true;
    q.offer(new int[] {r, c});
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      int row = curr[0], col = curr[1];
      area++;
      if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
        isOnBoundary = true;
      }
      for (int[] dir : directions) {
        int nextRow = row + dir[0];
        int nextCol = col + dir[1];
        if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
          continue;
        }
        if (grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          q.offer(new int[] {nextRow, nextCol});
        }
      }
    }
    return isOnBoundary ? 0 : area;
  }

  public int numEnclaves(int[][] grid) {
    int n = grid.length, m = grid[0].length, count = 0;
    boolean[][] visited = new boolean[n][m];
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < m; c++) {
        if (grid[r][c] == 1 && !visited[r][c]) {
          count += bfs(grid, visited, r, c);
        }
      }
    }
    return count;
  }
}
