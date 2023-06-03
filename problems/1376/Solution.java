import java.util.*;

class Solution {
  int res = 0;

  public void dfs(int curr, Map<Integer, List<Integer>> graph, int totalTime, int[] informTime) {
    if (!graph.containsKey(curr)) {
      return;
    }
    totalTime += informTime[curr];
    res = Math.max(res, totalTime);
    for (int child : graph.get(curr)) {
      dfs(child, graph, totalTime, informTime);
    }
  }

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < manager.length; i++) {
      graph.computeIfAbsent(manager[i], k -> new LinkedList<>()).add(i);
    }

    dfs(headID, graph, 0, informTime);

    return res;
  }
}
