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
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
      if (node != null) {
        minHeap.offer(node);
      }
    }
    ListNode dummy = new ListNode(0), curr = dummy;
    while (!minHeap.isEmpty()) {
      ListNode currMin = minHeap.poll();
      curr.next = currMin;
      curr = curr.next;
      currMin = currMin.next;
      if (currMin != null) {
        minHeap.offer(currMin);
      }
    }
    return dummy.next;
  }
}
