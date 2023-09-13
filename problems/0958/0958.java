import java.util.*;

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
  public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node == null) {
        for (TreeNode n : q) {
          if (n != null) {
            return false;
          }
        }
        return true;
      }
      q.offer(node.left);
      q.offer(node.right);
    }
    return true;
  }
}
