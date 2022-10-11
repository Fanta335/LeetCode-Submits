/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    int[][] counts;

    public int maximalSquare(char[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        counts = new int[M][N];
        int max = 0;

        for (int x = 0; x < N; x++) {
            if (matrix[0][x] == '1') {
                counts[0][x] = 1;
                max = 1;
            }
        }
        for (int y = 1; y < M; y++) {
            if (matrix[y][0] == '1') {
                counts[y][0] = 1;
                max = 1;
            }
        }
        for (int y = 1; y < M; y++) {
            for (int x = 1; x < N; x++) {
                if (matrix[y][x] == '1') {
                    counts[y][x] = Math.min(counts[y - 1][x - 1],
                            Math.min(counts[y - 1][x], counts[y][x - 1])) + 1;
                    max = Math.max(max, counts[y][x] * counts[y][x]);
                }
            }
        }
        return max;
    }
}
// @lc code=end

