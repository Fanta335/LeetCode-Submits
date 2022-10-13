import java.util.Stack;

/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null && fast.next == null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.peek().val != slow.val) {
                break;
            }
            stack.pop();
            slow = slow.next;
        }

        return stack.isEmpty();
    }
}
// @lc code=end

