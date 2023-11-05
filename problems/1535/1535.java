import java.util.*;

class Solution {
  public int getWinner(int[] arr, int k) {
    LinkedList<Integer> nodes = new LinkedList<>();
    int maxVal = arr[0];

    for (int num : arr) {
      nodes.add(num);
      maxVal = Math.max(maxVal, num);
    }

    k = Math.min(k, arr.length);

    int count = 0;
    while (count < k) {
      if (nodes.get(0) == maxVal) {
        return nodes.get(0);
      }
      if (nodes.get(0) < nodes.get(1)) {
        count = 0;
        int curr = nodes.remove(0);
        nodes.add(curr);
      } else {
        int curr = nodes.remove(1);
        nodes.add(curr);
      }
      count++;
    }

    return nodes.get(0);
  }
}
