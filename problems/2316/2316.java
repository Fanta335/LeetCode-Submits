import java.util.*;

class Solution {
  public long countPairs(int n, int[][] edges) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] e : edges) {
      adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
      adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
    }
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    long res = 0;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      stack.push(i);
      long count = 0;
      while (!stack.empty()) {
        int curr = stack.pop();
        if (!visited[curr]) {
          visited[curr] = true;
          count++;
        }
        if (!adj.containsKey(curr)) {
          continue;
        }
        for (int node : adj.get(curr)) {
          if (!visited[node]) {
            visited[node] = true;
            stack.push(node);
            count++;
          }
        }
      }
      res += sum * count;
      sum += count;
    }
    return res;
  }
}
