/*
 * @lc app=leetcode id=1314 lang=java
 *
 * [1314] Matrix Block Sum
 */

// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] memo = new int[M + 1][N + 1];
        int[][] res = new int[M][N];

        for (int r = 1; r < M + 1; r++) {
            for (int c = 1; c < N + 1; c++) {
                memo[r][c] =
                        mat[r - 1][c - 1] + memo[r][c - 1] + memo[r - 1][c] - memo[r - 1][c - 1];
            }
        }

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                int r1 = Math.max(0, r - k);
                int r2 = Math.min(M - 1, r + k);
                int c1 = Math.max(0, c - k);
                int c2 = Math.min(N - 1, c + k);
                r1++;
                r2++;
                c1++;
                c2++;
                res[r][c] =
                        memo[r2][c2] - memo[r2][c1 - 1] - memo[r1 - 1][c2] + memo[r1 - 1][c1 - 1];
            }
        }

        return res;
    }
}
// @lc code=end

