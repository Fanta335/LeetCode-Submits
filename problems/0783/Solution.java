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
  public long helper(TreeNode node, long min, long max) {
    if (node == null) {
      return max - min;
    }
    return Math.min(helper(node.left, min, node.val), helper(node.right, node.val, max));
  }

  public int minDiffInBST(TreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    return (int) Math.min(helper(root.left, Integer.MIN_VALUE, root.val),
        helper(root.right, root.val, Integer.MAX_VALUE));
  }
}
