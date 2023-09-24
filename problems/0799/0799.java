import java.util.*;

class Solution {
  public double champagneTower(int poured, int query_row, int query_glass) {
    List<List<Double>> dp = new ArrayList<>();
    dp.add(new ArrayList<>());
    dp.get(0).add((double) poured);
    for (int i = 1; i <= query_row; i++) {
      dp.add(new ArrayList<>());
      List<Double> prevRow = dp.get(i - 1);
      dp.get(i).add(Math.max((prevRow.get(0) - 1) / 2, 0));
      for (int j = 1; j < i; j++) {
        double overflow = Math.max((prevRow.get(j - 1) - 1) / 2, 0) + Math.max((prevRow.get(j) - 1) / 2, 0);
        dp.get(i).add(overflow);
      }
      dp.get(i).add(Math.max((prevRow.get(i - 1) - 1) / 2, 0));
    }
    double res = dp.get(query_row).get(query_glass);
    if (res < 0) {
      return (double) 0;
    } else if (res > 1) {
      return (double) 1;
    } else {
      return res;
    }
  }
}
