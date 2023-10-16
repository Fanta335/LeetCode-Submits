import java.util.*;

class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    res.add(1);

    for (int row = 1; row <= rowIndex; row++) {
      res.add(1);
      for (int col = row - 1; col > 0; col--) {
        res.set(col, res.get(col) + res.get(col - 1));
      }
    }

    return res;
  }
}
