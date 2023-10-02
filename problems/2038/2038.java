class Solution {
  public boolean winnerOfGame(String colors) {
    boolean isAliceTurn = true;
    int N = colors.length(), a = 1, b = 1;
    while (a < N && b < N) {
      if (isAliceTurn) {
        if (a == N - 1) {
          return false;
        }
        if (canRemove(colors, isAliceTurn, a)) {
          isAliceTurn = false;
        }
        a++;
      } else {
        if (b == N - 1) {
          return true;
        }
        if (canRemove(colors, isAliceTurn, b)) {
          isAliceTurn = true;
        }
        b++;
      }
    }
    return a < N - 1;
  }

  private boolean canRemove(String colors, boolean isAliceTurn, int idx) {
    char ch = isAliceTurn ? 'A' : 'B';
    return colors.charAt(idx - 1) == ch && colors.charAt(idx) == ch && colors.charAt(idx + 1) == ch;
  }
}
