/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int sameX = 0;
        int sameY = 0;
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] == coordinates[i - 1][0]) {
                sameX++;
            }
            if (coordinates[i][1] == coordinates[i - 1][1]) {
                sameY++;
            }
        }
        if (sameX == coordinates.length - 1 || sameY == coordinates.length - 1) {
            return true;
        }
        double grad = (double) (coordinates[1][1] - coordinates[0][1])
                / (coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            if (grad != (double) (coordinates[i][1] - coordinates[i - 1][1])
                    / (coordinates[i][0] - coordinates[i - 1][0])) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

