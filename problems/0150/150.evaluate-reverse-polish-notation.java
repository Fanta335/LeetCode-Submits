import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                int op1 = Integer.valueOf(stack.pop());
                int op2 = Integer.valueOf(stack.pop());
                if (s.equals("+")) {
                    stack.push(String.valueOf(op2 + op1));
                } else if (s.equals("-")) {
                    stack.push(String.valueOf(op2 - op1));
                } else if (s.equals("*")) {
                    stack.push(String.valueOf(op2 * op1));
                } else if (s.equals("/")) {
                    stack.push(String.valueOf(op2 / op1));
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }
}
// @lc code=end

