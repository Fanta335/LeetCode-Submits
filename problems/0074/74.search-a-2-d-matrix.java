/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int start = 0;
        int end = M - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                if (matrix[mid][N - 1] < target) {
                    start = mid + 1;
                } else {
                    start = mid;
                    break;
                }
            }
        }
        int c = start;
        if (c < 0 || c >= M) {
            return false;
        }
        start = 0;
        end = N - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (matrix[c][mid] == target) {
                return true;
            } else if (matrix[c][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end

