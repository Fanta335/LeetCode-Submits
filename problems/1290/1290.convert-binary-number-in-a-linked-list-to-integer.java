/*
 * @lc app=leetcode id=1290 lang=java
 *
 * [1290] Convert Binary Number in a Linked List to Integer
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
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum *= 2;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }
}
// @lc code=end

