import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
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


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node curr = newHead;
        while (curr != null) {
            updateMap(map, head.next);
            curr.next = map.get(head.next);
            updateMap(map, head.random);
            curr.random = map.get(head.random);
            curr = curr.next;
            head = head.next;
        }
        return newHead;
    }

    private void updateMap(Map<Node, Node> map, Node node) {
        if (!map.containsKey(node)) {
            if (node == null) {
                map.put(node, null);
            } else {
                map.put(node, new Node(node.val));
            }
        }
    }
}
// @lc code=end

