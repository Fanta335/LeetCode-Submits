import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() < level + 1) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        helper(node.left, list, level + 1);
        helper(node.right, list, level + 1);
    }
}
// @lc code=end

