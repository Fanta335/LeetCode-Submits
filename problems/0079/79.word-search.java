/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int M = board.length;
        if (M == 0) {
            return false;
        }
        int N = board[0].length;
        this.visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existHelper(board, word, i, j, 0)) {
                        return true;
                    }
                    this.visited = new boolean[M][N];
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, String word, int i, int j, int offset) {
        if (offset == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(offset)){
            return false;
        }
        visited[i][j] = true;
        boolean found = existHelper(board, word, i + 1, j, offset + 1)
                || existHelper(board, word, i - 1, j, offset + 1)
                || existHelper(board, word, i, j + 1, offset + 1)
                || existHelper(board, word, i, j - 1, offset + 1);
        if (!found) {
            visited[i][j] = false;
        }
        return found;
    }
}
// @lc code=end

