import java.util.*;

class Solution {
  int[][] DIRS =
      new int[][] {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
  int MOD = (int) 1e9 + 7;

  public int knightDialer(int n) {
    long[][] dp = new long[4][3];
    Queue<long[]> q = new LinkedList<>();

    for (long[] row : dp) {
      Arrays.fill(row, 1);
    }
    dp[3][0] = 0;
    dp[3][2] = 0;

    for (int i = 1; i < n; i++) {
      offerCount(dp, q);
      long[][] next = new long[4][3];

      while (!q.isEmpty()) {
        long[] curr = q.poll();
        int r = (int) curr[0], c = (int) curr[1];
        long count = curr[2];

        for (int[] dir : DIRS) {
          int nextR = r + dir[1], nextC = c + dir[0];
          if (nextR < 0 || nextR > 3 || nextC < 0 || nextC > 2 || (nextR == 3 && nextC == 0) || (nextR == 3 && nextC == 2)) {
            continue;
          }
          next[nextR][nextC] = (next[nextR][nextC] + count) % MOD;
        }
      }

      dp = next;
    }

    long ans = 0;

    for (long[] row : dp) {
      for (long col : row) {
        ans = (ans + col) % MOD;
      }
    }

    return (int) ans;
  }

  private void offerCount(long[][] dp, Queue<long[]> q) {
    for (int r = 0; r < 4; r++) {
      for (int c = 0; c < 3; c++) {
        if ((r == 3 && c == 0) || (r == 3 && c == 2)) {
          continue;
        }
        q.offer(new long[] {r, c, dp[r][c]});
      }
    }
  }
}
