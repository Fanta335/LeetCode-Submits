class Solution {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[] pos = new int[] {0, 0};
    int currDir = 0;
    for (int i = 0; i < n * n; i++) {
      res[pos[0]][pos[1]] = i + 1;
      pos[0] += dirs[currDir][0];
      pos[1] += dirs[currDir][1];
      if (pos[0] < 0 || pos[0] >= n || pos[1] < 0 || pos[1] >= n || res[pos[0]][pos[1]] != 0) {
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
