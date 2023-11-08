class Solution {
  public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    if (sx == fx && sy == fy) {
      return t != 1;
    }

    if (sx == fx || sy == fy) {
      return getLinearDist(sx, sy, fx, fy) <= t;
    }

    int diagonalMoveDist = Math.min(Math.abs(sx - fx), Math.abs(sy - fy));
    int[] dirToMove = getDirToMove(sx, sy, fx, fy);
    int cx = sx + diagonalMoveDist * dirToMove[0], cy = sy + diagonalMoveDist * dirToMove[1];
    t -= diagonalMoveDist;

    return getLinearDist(cx, cy, fx, fy) <= t;
  }

  private int getLinearDist(int sx, int sy, int fx, int fy) {
    return Math.abs(sx - fx) + Math.abs(sy - fy);
  }

  private int[] getDirToMove(int sx, int sy, int fx, int fy) {
    if (sx < fx && sy > fy) {
      return new int[] {1, -1};
    }
    if (sx < fx && sy < fy) {
      return new int[] {1, 1};
    }
    if (sx > fx && sy < fy) {
      return new int[] {-1, 1};
    }
    if (sx > fx && sy > fy) {
      return new int[] {-1, -1};
    }
    return null;
  }
}
