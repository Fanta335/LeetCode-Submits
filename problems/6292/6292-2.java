class Solution {
  public int[][] rangeAddQueries(int n, int[][] queries) {
    int[][] mat = new int[n][n];

    for (int[] query : queries) {
      int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
      mat[row1][col1] += 1;
      if (row2 + 1 < n && col2 + 1 < n) {
        mat[row2 + 1][col2 + 1] += 1;
      }
      if (row2 + 1 < n) {
        mat[row2 + 1][col1] -= 1;
      }
      if (col2 + 1 < n) {
        mat[row1][col2 + 1] -= 1;
      }
    }

    for (int r = 0; r < n; r++) {
      for (int c = 1; c < n; c++) {
        mat[r][c] += mat[r][c - 1];
      }
    }

    for (int r = 1; r < n; r++) {
      for (int c = 0; c < n; c++) {
        mat[r][c] += mat[r - 1][c];
      }
    }

    return mat;
  }
}
