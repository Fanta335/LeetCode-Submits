import java.util.*;

class Solution {
  public int[] restoreArray(int[][] adjacentPairs) {
    int N = adjacentPairs.length + 1;
    int[] ans = new int[N];

    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] pair : adjacentPairs) {
      graph.computeIfAbsent(pair[0], k -> new ArrayList<Integer>()).add(pair[1]);
      graph.computeIfAbsent(pair[1], k -> new ArrayList<Integer>()).add(pair[0]);
    }

    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      if (entry.getValue().size() == 1) {
        ans[0] = entry.getKey();
        break;
      }
    }

    int curr = graph.get(ans[0]).get(0);

    for (int i = 1; i < N - 1; i++) {
      ans[i] = curr;
      List<Integer> adjs = graph.get(curr);
      if (ans[i - 1] == adjs.get(0)) {
        curr = adjs.get(1);
      } else {
        curr = adjs.get(0);
      }
    }

    ans[N - 1] = curr;

    return ans;
  }
}
