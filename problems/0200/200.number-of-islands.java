/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    boolean[][] seen;

    public int numIslands(char[][] grid) {
        int count = 0;
        int M = grid.length;
        int N = grid[0].length;
        this.seen = new boolean[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!this.seen[r][c] && grid[r][c] == '1') {
                    walkIsland(grid, r, c);
                    count++;
                }
            }
        }

        return count;
    }

    private void walkIsland(char[][] grid, int r, int c) {
        if (this.seen[r][c]) {
            return;
        }
        this.seen[r][c] = true;
        if (grid[r][c] == '1') {
            if (r > 0) {
                walkIsland(grid, r - 1, c);
            }
            if (r < grid.length - 1) {
                walkIsland(grid, r + 1, c);
            }
            if (c > 0) {
                walkIsland(grid, r, c - 1);
            }
            if (c < grid[0].length - 1) {
                walkIsland(grid, r, c + 1);
            }
        }
    }
}
// @lc code=end

