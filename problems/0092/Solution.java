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
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0, head), curr = head, prev = dummy;
    int count = 1;
    while (count < left) {
      curr = curr.next;
      prev = prev.next;
      count++;
    }
    ListNode ll = prev, r = curr;
    prev = null;
    while (count <= right) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
      count++;
    }
    ll.next = prev;
    if (r != null) {
      r.next = curr;
    }

    return dummy.next;
  }
}
