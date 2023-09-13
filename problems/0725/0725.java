
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
  public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] res = new ListNode[k];
    ListNode curr = head;
    int n = 0;
    while (curr != null) {
      n++;
      curr = curr.next;
    }
    curr = head;
    int i = 0;
    while (curr != null) {
      res[i++] = curr;
      double len = (double) n / k;
      for (int j = 0; j < len - 1; j++) {
        curr = curr.next;
      }
      ListNode temp = curr;
      curr = curr.next;
      temp.next = null;
      n -= (int) Math.ceil(len);
      k--;
    }

    return res;
  }
}
