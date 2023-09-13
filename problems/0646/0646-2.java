import java.util.*;

class Solution {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
    int res = 1, prev = pairs[0][1];
    for (int i = 1; i < pairs.length; i++) {
      if (prev < pairs[i][0]) {
        res++;
        prev = pairs[i][1];
      }
    }

    return res;
  }
}
