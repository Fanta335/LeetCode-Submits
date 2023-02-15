import java.util.Stack;

public class Solution {
  public int helper(int[] arr) {
    int N = arr.length;
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    for (int i = 0; i <= N; i++) {
      while (!stack.isEmpty() && (i == N || arr[stack.peek()] > arr[i])) {
        int h = arr[stack.pop()];
        int w = !stack.isEmpty() ? i - stack.peek() - 1 : i;
        res = Math.max(res, h * w);
      }
      stack.push(i);
    }
    return res;
  }

  public int maximalRectangle(char[][] mat) {
    int H = mat.length, W = mat[0].length;
    int[][] dp = new int[H][W];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        dp[i][j] = mat[i][j] == '1' ? 1 : 0;
        if (dp[i][j] > 0 && i > 0) {
          dp[i][j] += dp[i - 1][j];
        }
      }
    }

    int maxArea = 0;
    for (int[] arr : dp) {
      int N = arr.length;
      Stack<Integer> stack = new Stack<>();
      int currArea = 0;
      for (int i = 0; i <= N; i++) {
        while (!stack.isEmpty() && (i == N || arr[stack.peek()] > arr[i])) {
          int h = arr[stack.pop()];
          int w = !stack.isEmpty() ? i - stack.peek() - 1 : i;
          currArea = Math.max(currArea, h * w);
        }
        stack.push(i);
      }
      maxArea = Math.max(maxArea, currArea);
    }
    return maxArea;
  }
}
