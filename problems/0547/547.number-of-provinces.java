/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        seen = new boolean[isConnected.length];
        for (int r = 0; r < isConnected.length; r++) {
            if (!seen[r]) {
                checkConnectedCity(isConnected, r);
                count++;
            }
        }
        return count;
    }

    private void checkConnectedCity(int[][] isConnected, int r) {
        if (seen[r]) {
            return;
        }
        seen[r] = true;
        for (int c = 0; c < isConnected[r].length; c++) {
            if (isConnected[r][c] == 1) {
                checkConnectedCity(isConnected, c);
            }
        }
    }
}
// @lc code=end

