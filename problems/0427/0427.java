class Node {
  public boolean val;
  public boolean isLeaf;
  public Node topLeft;
  public Node topRight;
  public Node bottomLeft;
  public Node bottomRight;


  public Node() {
    this.val = false;
    this.isLeaf = false;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public Node(boolean val, boolean isLeaf) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
      Node bottomRight) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = topLeft;
    this.topRight = topRight;
    this.bottomLeft = bottomLeft;
    this.bottomRight = bottomRight;
  }
};


class Solution {
  private Node createTree(int[][] grid, int x, int y, int len) {
    boolean isLeaf = true;
    for (int r = y; r < y + len && isLeaf; r++) {
      for (int c = x; c < x + len; c++) {
        if (grid[y][x] != grid[r][c]) {
          isLeaf = false;
          break;
        }
      }
    }
    Node parent = new Node(grid[y][x] == 1, isLeaf);
    if (isLeaf) {
      return parent;
    }
    parent.topLeft = createTree(grid, x, y, len / 2);
    parent.topRight = createTree(grid, x + len / 2, y, len / 2);
    parent.bottomLeft = createTree(grid, x, y + len / 2, len / 2);
    parent.bottomRight = createTree(grid, x + len / 2, y + len / 2, len / 2);
    return parent;
  }

  public Node construct(int[][] grid) {
    return createTree(grid, 0, 0, grid.length);
  }
}
