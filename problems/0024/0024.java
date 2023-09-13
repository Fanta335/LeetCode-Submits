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
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode curr = dummy;

    while (curr.next != null && curr.next.next != null) {
      ListNode temp = curr.next;
      curr.next = temp.next;
      temp.next = temp.next.next;
      curr.next.next = temp;
      curr = curr.next.next;
    }

    return dummy.next;
  }
}
