import java.util.*;

class Solution {
  public List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> res = new LinkedList<>();
    int i = num.length - 1, curr = k;
    while (i >= 0 || curr > 0) {
      if (i >= 0) {
        curr += num[i--];
      }
      res.add(0, curr % 10);
      curr /= 10;
    }
    return res;
  }
}
