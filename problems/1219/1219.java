class Solution {
  int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int getMaximumGold(int[][] grid) {
    int maxGold = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        maxGold = Math.max(maxGold, dfs(grid, i, j));
      }
    }

    return maxGold;
  }

  private int dfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
      return 0;
    }

    int max = 0;
    int originalVal = grid[i][j];
    grid[i][j] = 0;

    for (int[] dir : dirs) {
      max = Math.max(max, originalVal + dfs(grid, i + dir[0], j + dir[1]));
    }

    grid[i][j] = originalVal;

    return max;
  }
}
