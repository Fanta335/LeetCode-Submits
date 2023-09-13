import java.util.*;

class Solution {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int n = people.length, l = 0, r = n - 1, count = 0;
    while (l < r) {
      int sum = people[l] + people[r];
      if (sum <= limit) {
        count++;
        l++;
        r--;
      } else {
        count++;
        r--;
      }
    }
    return l == r ? count + 1 : count;
  }
}
