import java.util.*;

class Solution {
  public int largestSubmatrix(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];

    for (int c = 0; c < n; c++) {
      int con = 0;
      for (int r = m - 1; r >= 0; r--) {
        int curr = matrix[r][c];
        if (curr == 0) {
          con = 0;
        } else {
          con++;
        }
        dp[r][c] = con;
      }
    }

    for (int[] row : dp) {
      Arrays.sort(row);
    }

    int ans = 0;

    for (int r = 0; r < m; r++) {
      for (int c = n - 1; c >= 0; c--) {
        int curr = dp[r][c];
        if (curr == 0) {
          break;
        }
        int area = (n - c) * curr;
        ans = Math.max(ans, area);
      }
    }

    return ans;
  }
}
