// import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
// class Solution {
// public int kthSmallest(int[][] matrix, int k) {
// int N = matrix.length;
// int[] list = new int[N * N];
// for (int i = 0; i < N; i++) {
// for (int j = 0; j < N; j++) {
// list[N * j + i] = matrix[i][j];
// }
// }
// Arrays.sort(list);
// return list[k - 1];
// }
// }

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                maxHeap.offer(matrix[x][y]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}


// @lc code=end

