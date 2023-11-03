import java.util.*;

class Solution {
  public List<String> buildArray(int[] target, int n) {
    List<String> operations = new ArrayList<>();
    int i = 1, j = 0;

    while (i <= n && j < target.length) {
      operations.add("Push");
      if (target[j] == i) {
        j++;
      } else {
        operations.add("Pop");
      }
      i++;
    }

    return operations;
  }
}
