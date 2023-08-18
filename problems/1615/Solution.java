import java.util.*;

class Solution {
  public int maximalNetworkRank(int n, int[][] roads) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] road : roads) {
      graph.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
      graph.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
    }
    int res = 0;
    for (int c1 : graph.keySet()) {
      for (int c2 = c1 + 1; c2 < n; c2++) {
        if (!graph.containsKey(c2)) {
          continue;
        }
        int count = graph.get(c1).size() + graph.get(c2).size();
        if (graph.get(c2).contains(c1)) {
          count--;
        }
        res = Math.max(res, count);
      }
    }

    return res;
  }
}
