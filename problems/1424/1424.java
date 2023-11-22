import java.util.*;

class Solution {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<List<Integer>> diagonal = new ArrayList<>();
    int startRow = 0, ansSize = 0;

    for (List<Integer> row : nums) {
      int currRow = startRow;
      for (int num : row) {
        if (diagonal.size() == currRow) {
          diagonal.add(new LinkedList<>());
        }
        diagonal.get(currRow).add(0, num);
        currRow++;
        ansSize++;
      }
      startRow++;
    }

    int[] ans = new int[ansSize];
    int idx = 0;
    for (List<Integer> row : diagonal) {
      for (int num : row) {
        ans[idx++] = num;
      }
    }

    return ans;
  }
}
