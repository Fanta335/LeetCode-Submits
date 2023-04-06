import java.util.*;

class Solution {
  int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int closedIsland(int[][] grid) {
    int n = grid.length, m = grid[0].length, count = 0;
    boolean[][] visited = new boolean[n][m];
    Queue<List<Integer>> q = new LinkedList<>();
    for (int r = 1; r < n - 1; r++) {
      for (int c = 1; c < m - 1; c++) {
        if (visited[r][c] || grid[r][c] == 1) {
          continue;
        }
        if (grid[r][c] == 0) {
          q.offer(Arrays.asList(r, c));
          boolean isClosed = true;
          while (!q.isEmpty()) {
            List<Integer> curr = q.poll();
            int x = curr.get(1), y = curr.get(0);
            System.out.println(y + " " + x);
            if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
              isClosed = false;
              continue;
            }
            visited[y][x] = true;
            for (int[] dir : directions) {
              int nextX = x + dir[1], nextY = y + dir[0];
              if (!visited[nextY][nextX] && grid[nextY][nextX] == 0) {
                q.offer(Arrays.asList(nextY, nextX));
              }
            }
          }
          if (isClosed) {
            System.out.println("closed!");
            count++;
          } else {
            System.out.println("not closed...");
          }
        }
      }
    }
    return count;
  }
}
