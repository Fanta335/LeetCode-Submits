/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        ListNode pred = curr.next;
        while (pred != null && pred.next != null) {
            if (pred.val == pred.next.val) {
                int dup = pred.val;
                while (pred != null && pred.val == dup) {
                    pred = pred.next;
                }
            } else {
                curr.next = pred;
                pred = pred.next;
                curr = curr.next;
            }
        }
        curr.next = pred;
        return dummy.next;
    }
}
// @lc code=end

