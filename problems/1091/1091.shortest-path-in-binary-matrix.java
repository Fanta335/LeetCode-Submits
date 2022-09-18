import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    boolean[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;

        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {
            return -1;
        }

        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            int steps = node[2];

            if (x == N - 1 && y == N - 1) {
                return steps;
            }

            int[][] nextPositions = new int[][] {{x - 1, y - 1}, {x, y - 1}, {x + 1, y - 1},
                    {x + 1, y}, {x + 1, y + 1}, {x, y + 1}, {x - 1, y + 1}, {x - 1, y}};

            for (int[] pos : nextPositions) {
                int posX = pos[0];
                int posY = pos[1];
                if (posX >= 0 && posX < N && posY >= 0 && posY < N && !visited[posX][posY]
                        && grid[posX][posY] == 0) {
                    visited[posX][posY] = true;
                    q.offer(new int[] {posX, posY, steps + 1});
                }
            }
        }

        return -1;
    }
}
// @lc code=end

