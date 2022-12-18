/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            return node.left.val + helper(node.right, sum);
        }
        return helper(node.left, sum) + helper(node.right, sum);
    }
}
// @lc code=end

