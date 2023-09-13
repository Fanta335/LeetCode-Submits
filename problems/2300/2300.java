import java.util.*;

class Solution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int n = spells.length, m = potions.length;
    int[] pairs = new int[n];
    for (int i = 0; i < n; i++) {
      int l = 0, r = m - 1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        if ((long) spells[i] * potions[mid] >= success) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
      pairs[i] = m - l;
    }
    return pairs;
  }
}
