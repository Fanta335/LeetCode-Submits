/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        return isValidSubBST(root.left, root.val, null)
                && isValidSubBST(root.right, null, root.val);
    }

    private boolean isValidSubBST(TreeNode node, Integer max, Integer min) {
        if (node == null) {
            return true;
        }
        if (max != null && max <= node.val || min != null && min >= node.val) {
            return false;
        }
        return isValidSubBST(node.left, node.val, min) && isValidSubBST(node.right, max, node.val);
    }
}
// @lc code=end

