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
  private boolean isSameVal(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return true;
    }
    if (a == null || b == null) {
      return false;
    }
    return a.val == b.val && isSameVal(a.left, b.right) && isSameVal(a.right, b.left);
  }

  public boolean isSymmetric(TreeNode root) {
    return isSameVal(root.left, root.right);
  }
}
