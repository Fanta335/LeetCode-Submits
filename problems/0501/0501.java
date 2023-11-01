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
  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> counts = new HashMap<>();
    dfs(root, counts);

    int currMax = 0;
    List<Integer> modes = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      int key = entry.getKey();
      int count = entry.getValue();
      if (count > currMax) {
        modes.clear();
        modes.add(key);
        currMax = count;
      } else if (count == currMax) {
        modes.add(key);
      }
    }

    int[] ans = new int[modes.size()];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = modes.get(i);
    }
    return ans;
  }

  private void dfs(TreeNode node, Map<Integer, Integer> counts) {
    if (node == null) {
      return;
    }

    counts.put(node.val, counts.getOrDefault(node.val, 0) + 1);
    dfs(node.left, counts);
    dfs(node.right, counts);
  }
}
