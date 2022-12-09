/*
 * @lc app=leetcode id=1779 lang=java
 *
 * [1779] Find Nearest Point That Has the Same X or Y Coordinate
 */

// @lc code=start
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int N = points.length;
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (points[i][0] == x || points[i][1] == y) {
                int dist = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (min >= dist) {
                    min = dist;
                    res = i;
                }
            }
        }
        return res;
    }
}
// @lc code=end

