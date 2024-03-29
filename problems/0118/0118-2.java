import java.util.*;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    res.get(0).add(1);
    for (int i = 1; i < numRows; i++) {
      List<Integer> curr = new ArrayList<>(), prev = res.get(i - 1);
      curr.add(1);
      for (int j = 1; j < i; j++) {
        curr.add(prev.get(j - 1) + prev.get(j));
      }
      curr.add(1);
      res.add(curr);
    }
    return res;
  }
}
