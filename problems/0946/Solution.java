import java.util.*;

class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int n = pushed.length, i = 0, j = 0;
    while (i < n) {
      stack.push(pushed[i++]);
      while (j < n && !stack.isEmpty() && stack.peek() == popped[j]) {
        stack.pop();
        j++;
      }
    }
    return stack.isEmpty();
  }
}
