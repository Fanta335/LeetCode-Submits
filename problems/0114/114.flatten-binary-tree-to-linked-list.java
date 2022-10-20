import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        preorder(root, q);
        toLinkedList(q);
    }

    private void preorder(TreeNode node, Queue<TreeNode> q) {
        if (node == null) {
            return;
        }
        q.offer(node);
        preorder(node.left, q);
        preorder(node.right, q);
    }

    private void toLinkedList(Queue<TreeNode> q) {
        TreeNode dummy = new TreeNode(0);
        TreeNode curr = dummy;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            curr.right = node;
            curr.left = null;
            curr = curr.right;
        }
    }
}
// @lc code=end

