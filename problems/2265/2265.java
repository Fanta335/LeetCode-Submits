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
  int count = 0;

  public int averageOfSubtree(TreeNode root) {
    dfs(root);
    return count;
  }

  private int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[] {0, 0};
    }

    int[] left = dfs(node.left);
    int[] right = dfs(node.right);

    int currSum = left[0] + right[0] + node.val;
    int currSize = left[1] + right[1] + 1;

    if (currSum / currSize == node.val) {
      count++;
    }

    return new int[] {currSum, currSize};
  }
}
