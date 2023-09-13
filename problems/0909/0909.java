class Solution {
  static int res;

  public static void bfs(int[][] board, int curr, int count) {
    int n = board.length;
    if (curr >= n * n) {
      res = Math.min(res, count);
      return;
    }
    for (int i = 1; i <= 6; i++) {
      int r = n - 1 - (curr + i - 1) / n;
      int c = (n - r) % 2 != 0 ? ((curr + i) % n - 1) : (n - ((curr + i) % n));
      c = c == n ? 0 : c;
      if (curr + i > n * n) {
        break;
      }
      // System.out.println(r);
      // System.out.println(c);
      // System.out.println(curr + i);
      if (board[r][c] != -1) {
        bfs(board, board[r][c], count + 1);
      } else if (i == 6) {
        bfs(board, curr + 6, count + 1);
      }
    }
  }

  public static int snakesAndLadders(int[][] board) {
    res = Integer.MAX_VALUE;
    bfs(board, 1, 0);
    return res;
  }

  public static void main(String[] args) {
    int[][] mat =
    new int[][] {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
    {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
    System.out.println(Solution.snakesAndLadders(mat));
  }
}
