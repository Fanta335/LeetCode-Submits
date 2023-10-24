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
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int currLength = q.size();
      int currMax = Integer.MIN_VALUE;

      for (int i = 0; i < currLength; i++) {
        TreeNode node = q.poll();
        currMax = Math.max(currMax, node.val);

        if (node.left != null) {
          q.offer(node.left);
        }

        if (node.right != null) {
          q.offer(node.right);
        }
      }

      res.add(currMax);
    }

    return res;
  }
}
