import java.util.*;

class Solution {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    Set<Integer> set = new HashSet<>();
    boolean[] visited = new boolean[n];
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (List<Integer> edge : edges) {
      adj.computeIfAbsent(edge.get(0), k -> new LinkedList<>()).add(edge.get(1));
    }
    for (Integer node : adj.keySet()) {
      if (!visited[node]) {
        visited[node] = true;
        set.add(node);
      }
      for (Integer adjacent : adj.get(node)) {
        if (visited[adjacent]) {
          set.remove(adjacent);
        }
        visited[adjacent] = true;
      }
    }

    return new ArrayList<>(set);
  }
}
