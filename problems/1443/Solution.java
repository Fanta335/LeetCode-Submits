import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  private int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
    if (!adj.containsKey(node)) {
      return 0;
    }
    int totalTime = 0, childTime = 0;
    for (int child : adj.get(node)) {
      if (child == parent) {
        continue;
      }
      childTime = dfs(child, node, adj, hasApple);
      if (childTime > 0 || hasApple.get(child)) {
        totalTime += childTime + 2;
      }
    }
    return totalTime;
  }

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] e : edges) {
      if (!adj.containsKey(e[0])) {
        adj.put(e[0], new ArrayList<>());
      }
      if (!adj.containsKey(e[1])) {
        adj.put(e[1], new ArrayList<>());
      }
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
    }
    return dfs(0, -1, adj, hasApple);
  }
}
