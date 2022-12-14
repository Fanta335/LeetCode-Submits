/*
 * @lc app=leetcode id=1572 lang=java
 *
 * [1572] Matrix Diagonal Sum
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        int N = mat[0].length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += mat[i][i] + mat[N - 1 - i][i];
        }
        if (N % 2 != 0) {
            sum -= mat[N / 2][N / 2];
        }
        return sum;
    }
}
// @lc code=end

