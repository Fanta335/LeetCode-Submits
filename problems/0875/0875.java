import java.util.*;

class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int low = 1, high = Arrays.stream(piles).max().getAsInt();
    while (low <= high) {
      System.out.println(low + " " + high);
      int mid = low + (high - low) / 2, totalTime = 0;
      for (int p : piles) {
        if (totalTime > h) {
          break;
        }
        totalTime += p % mid == 0 ? p / mid : p / mid + 1;
      }
      System.out.println(totalTime);
      if (totalTime > h) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    System.out.println(low + " " + high);
    return low;
  }
}
