/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (curr != null && a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                curr = a;
                a = a.next;
            } else {
                curr.next = b;
                curr = b;
                b = b.next;
            }
        }
        curr.next = a == null ? b : a;
        return dummy.next;
    }

    private ListNode getMiddle(ListNode node) {
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
}
// @lc code=end

