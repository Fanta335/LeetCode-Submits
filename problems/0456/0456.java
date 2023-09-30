import java.util.*;

class Solution {
  public boolean find132pattern(int[] nums) {
    int N = nums.length;
    if (N < 3) {
      return false;
    }
    int[] mins = new int[N];
    mins[0] = nums[0];
    for (int i = 1; i < N; i++) {
      mins[i] = Math.min(nums[i], mins[i - 1]);
    }
    System.out.println(Arrays.toString(mins));
    Stack<Integer> stack = new Stack<>();
    for (int i = N - 1; i >= 1; i--) {
      int curr = nums[i];
      while (!stack.isEmpty() && stack.peek() <= mins[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        if (curr > mins[i]) {
          stack.push(curr);
        }
      } else {
        if (curr > stack.peek()) {
          return true;
        } else if (curr < stack.peek()) {
          if (curr > mins[i]) {
            stack.push(curr);
          }
        }
      }
    }
    return false;
  }
}
