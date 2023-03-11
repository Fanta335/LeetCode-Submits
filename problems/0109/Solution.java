import java.util.*;

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}


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
  private TreeNode generateBST(List<Integer> list, int l, int r) {
    if (l > r) {
      return null;
    }
    int mid = l + (r - l) / 2;
    TreeNode node = new TreeNode(list.get(mid));
    node.left = generateBST(list, l, mid - 1);
    node.right = generateBST(list, mid + 1, r);
    return node;
  }

  public TreeNode sortedListToBST(ListNode head) {
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    int l = 0, r = list.size() - 1;
    TreeNode root = generateBST(list, l, r);
    return root;
  }
}
