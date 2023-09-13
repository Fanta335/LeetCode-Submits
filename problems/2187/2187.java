import java.util.*;

class Solution {
  public long minimumTime(int[] time, int totalTrips) {
    long l = 1, r = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
    while (l <= r) {
      System.out.println(l + " " + r);
      long mid = l + (r - l) / 2;
      long count = 0;
      for (int t : time) {
        count += mid / t;
      }
      if (count >= totalTrips) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}
