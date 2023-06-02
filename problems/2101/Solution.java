import java.util.*;

class Solution {
  public double getDistance(int[] bomb1, int[] bomb2) {
    return Math.sqrt(
        Math.pow(Math.abs(bomb1[0] - bomb2[0]), 2) + Math.pow(Math.abs(bomb1[1] - bomb2[1]), 2));
  }

  public int maximumDetonation(int[][] bombs) {
    int n = bombs.length;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        double dist = getDistance(bombs[i], bombs[j]);
        if (dist <= bombs[i][2]) {
          adj.computeIfAbsent(i, k -> new LinkedList<>()).add(j);
        }
        if (dist <= bombs[j][2]) {
          adj.computeIfAbsent(j, k -> new LinkedList<>()).add(i);
        }
      }
    }

    int res = 1;
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (!adj.containsKey(i)) {
        continue;
      }
      Arrays.fill(visited, false);
      visited[i] = true;
      int count = 1;
      stack.push(i);
      while (!stack.isEmpty()) {
        int curr = stack.pop();
        if (!adj.containsKey(curr)) {
          continue;
        }
        for (int j : adj.get(curr)) {
          if (visited[j]) {
            continue;
          }
          visited[j] = true;
          count++;
          stack.push(j);
        }
      }
      res = Math.max(res, count);
    }

    return res;
  }
}
