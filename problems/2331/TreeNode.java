public class TreeNode {
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
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null || root.right == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.right) || evaluateTree(root.left);
        }
        if (root.val == 3) {
            return evaluateTree(root.right) && evaluateTree(root.left);
        }
        return false;
    }
}
