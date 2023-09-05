import java.util.*;

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}


// class Solution {
// public Node copyRandomList(Node head) {
// if (head == null) {
// return null;
// }
// List<Node> nodes = new ArrayList<>();
// Map<Node, Integer> map = new HashMap<>();
// Node copyHead = new Node(0);
// Node copyCurr = copyHead, oriCurr = head;
// while (oriCurr != null) {
// Node copy = new Node(oriCurr.val);
// map.put(oriCurr, nodes.size());
// nodes.add(copy);
// copyCurr.next = copy;
// copyCurr = copyCurr.next;
// oriCurr = oriCurr.next;
// }
// copyCurr = copyHead.next;
// oriCurr = head;

// while (oriCurr != null) {
// if (oriCurr.random != null) {
// copyCurr.random = nodes.get(map.get(oriCurr.random));
// }
// copyCurr = copyCurr.next;
// oriCurr = oriCurr.next;
// }

// return copyHead.next;
// }
// }


class Solution {
  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node ptr = head;
    while (ptr != null) {
      map.put(ptr, new Node(ptr.val));
      ptr = ptr.next;
    }
    ptr = head;
    while (ptr != null) {
      map.get(ptr).next = map.get(ptr.next);
      map.get(ptr).random = map.get(ptr.random);
      ptr = ptr.next;
    }
    return map.get(head);
  }
}
