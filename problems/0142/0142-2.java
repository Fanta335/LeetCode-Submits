class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}


public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null && slow != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }
    if (fast == null) {
      return null;
    }
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }
}
