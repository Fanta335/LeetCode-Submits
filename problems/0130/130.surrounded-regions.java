import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    boolean[][] visited;

    public void solve(char[][] board) {
        int M = board.length;
        int N = board[0].length;
        visited = new boolean[M][N];
        Queue<int[]> toValidateQ = new LinkedList<>();
        Queue<int[]> toFlipQ = new LinkedList<>();

        for (int r = 1; r < M - 1; r++) {
            for (int c = 1; c < N - 1; c++) {
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    if (board[r][c] == 'O') {
                        toValidateQ.offer(new int[] {r, c});
                        toFlipQ.offer(new int[] {r, c});
                        boolean surrounded = true;

                        while (!toValidateQ.isEmpty()) {
                            int[] pos = toValidateQ.poll();
                            int x = pos[0];
                            int y = pos[1];

                            int[][] nextPos =
                                    new int[][] {{x, y + 1}, {x + 1, y}, {x, y - 1}, {x - 1, y}};

                            for (int[] p : nextPos) {
                                int px = p[0];
                                int py = p[1];
                                if (visited[px][py]) {
                                    continue;
                                }
                                visited[px][py] = true;
                                if (board[px][py] == 'O') {
                                    if (px == 0 || px == N - 1 || py == 0 || py == M - 1) {
                                        surrounded = false;
                                    } else {
                                        toValidateQ.offer(new int[] {px, py});
                                        toFlipQ.offer(new int[] {px, py});
                                    }
                                }
                            }
                        }

                        if (!surrounded) {
                            toFlipQ.clear();
                        }

                        while (!toFlipQ.isEmpty()) {
                            int[] pos = toFlipQ.poll();
                            board[pos[0]][pos[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
}
// @lc code=end

