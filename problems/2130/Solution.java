import java.util.*;

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
  public int pairSum(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    ListNode slow = head, fast = head;
    while (fast != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }
    int res = 0;
    while (slow != null) {
      res = Math.max(res, slow.val + stack.pop());
      slow = slow.next;
    }
    return res;
  }
}
