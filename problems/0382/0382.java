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
  ListNode head;
  int size;

  public Solution(ListNode head) {
    this.head = head;
    while (head != null) {
      size++;
      head = head.next;
    }
  }

  public int getRandom() {
    ListNode curr = head;
    double target = Math.random() * size;
    for (int i = 0; i < target - 1; i++) {
      curr = curr.next;
    }
    return curr.val;
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
