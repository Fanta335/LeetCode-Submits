import java.util.*;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    boolean[][] visited = new boolean[n][m];
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int currDir = 0;
    int[] pos = new int[] {0, 0};
    List<Integer> res = new LinkedList<>();
    for (int i = 0; i < n * m; i++) {
      visited[pos[0]][pos[1]] = true;
      res.add(matrix[pos[0]][pos[1]]);

      pos[0] += dirs[currDir][0];
      pos[1] += dirs[currDir][1];
      if (pos[0] < 0 || pos[0] >= n || pos[1] < 0 || pos[1] >= m || visited[pos[0]][pos[1]]) {
        pos[0] -= dirs[currDir][0];
        pos[1] -= dirs[currDir][1];
        currDir = (currDir + 1) % 4;
        pos[0] += dirs[currDir][0];
        pos[1] += dirs[currDir][1];
      }
    }

    return res;
  }
}
