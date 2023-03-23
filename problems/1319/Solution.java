import java.util.*;

class Solution {
  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] con : connections) {
      adj.computeIfAbsent(con[0], k -> new ArrayList<Integer>()).add(con[1]);
      adj.computeIfAbsent(con[1], k -> new ArrayList<Integer>()).add(con[0]);
    }
    int clusters = 0;
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) {
        continue;
      }
      stack.push(i);
      while (!stack.empty()) {
        int curr = stack.pop();
        visited.add(curr);
        if (!adj.containsKey(curr)) {
          continue;
        }
        for (int pc : adj.get(curr)) {
          if (!visited.contains(pc)) {
            visited.add(pc);
            stack.push(pc);
          }
        }
      }
      clusters++;
    }

    return clusters - 1;
  }
}
