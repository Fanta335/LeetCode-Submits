import java.util.*;

class Solution {
  public int minReorder(int n, int[][] connections) {
    Map<Integer, List<int[]>> adj = new HashMap<>();
    for (int[] con : connections) {
      adj.computeIfAbsent(con[0], k -> new ArrayList<int[]>()).add(new int[] {con[1], 1});
      adj.computeIfAbsent(con[1], k -> new ArrayList<int[]>()).add(new int[] {con[0], 0});
    }
    int count = 0;
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    visited[0] = true;
    while (!stack.empty()) {
      int curr = stack.pop();
      if (!adj.containsKey(curr)) {
        continue;
      }
      for (int[] node : adj.get(curr)) {
        if (!visited[node[0]]) {
          visited[node[0]] = true;
          stack.push(node[0]);
          if (node[1] == 1) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
