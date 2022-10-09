/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    int[][] sums;

    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        sums = new int[M][N];

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (y > 0) {
                    if (x > 0) {
                        sums[y][x] = Math.min(sums[y - 1][x], sums[y][x - 1]) + grid[y][x];
                    } else {
                        sums[y][x] = sums[y - 1][x] + grid[y][x];
                    }
                } else {
                    if (x > 0) {
                        sums[y][x] = sums[y][x - 1] + grid[y][x];
                    } else {
                        sums[y][x] = grid[y][x];
                    }
                }
            }
        }

        return sums[M - 1][N - 1];
    }
}
// @lc code=end

