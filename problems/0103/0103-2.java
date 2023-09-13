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
  public void helper(TreeNode node, List<List<Integer>> list, int level) {
    if (node == null) {
      return;
    }
    if (list.size() == level) {
      list.add(new LinkedList<>());
    }
    List<Integer> curr = list.get(level);
    if (level % 2 == 0) {
      curr.add(node.val);
    } else {
      curr.add(0, node.val);
    }
    helper(node.left, list, level + 1);
    helper(node.right, list, level + 1);
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    helper(root, res, 0);
    return res;
  }
}
