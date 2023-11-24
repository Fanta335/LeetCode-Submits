import java.util.*;

class Solution {
  public int maxCoins(int[] piles) {
    Arrays.sort(piles);
    int ans = 0;
    int l = 0, r = piles.length - 2;
    while (l < r) {
      ans += piles[r];
      r -= 2;
      l++;
    }
    return ans;
  }
}
