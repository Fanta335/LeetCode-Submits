/*
 * @lc app=leetcode id=566 lang=java
 *
 * [566] Reshape the Matrix
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int M = mat.length, N = mat[0].length;
        if (M * N != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < M * N; i++) {
            res[i / c][i % c] = mat[i / N][i % N];
        }
        return res;
    }
}
// @lc code=end

