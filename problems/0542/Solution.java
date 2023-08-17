import java.util.*;

class Solution {
  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<int[]> q = new LinkedList<>();

    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (mat[y][x] == 0) {
          q.offer(new int[] {y, x});
        } else {
          mat[y][x] = -1;
        }
      }
    }

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      int r = curr[0], c = curr[1];
      for (int[] dir : dirs) {
        int nextR = r + dir[0], nextC = c + dir[1];
        if (nextR < 0 || nextR == m || nextC < 0 || nextC == n || mat[nextR][nextC] != -1) {
          continue;
        }
        mat[nextR][nextC] = mat[r][c] + 1;
        q.offer(new int[] {nextR, nextC});
      }
    }

    return mat;
  }
}
