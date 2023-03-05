import java.util.*;

class Solution {
  public int minJumps(int[] arr) {
    int N = arr.length;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < N; i++) {
      graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
    }
    List<Integer> curr = new LinkedList<>();
    curr.add(0);
    Set<Integer> visited = new HashSet<>();
    visited.add(0);
    int steps = 0;

    while (!curr.isEmpty()) {
      List<Integer> next = new LinkedList<>();

      for (int node : curr) {
        if (node == N - 1) {
          return steps;
        }

        for (int child : graph.get(arr[node])) {
          if (!visited.contains(child)) {
            visited.add(child);
            next.add(child);
          }
        }

        graph.get(arr[node]).clear();

        if (node + 1 < N && !visited.contains(node + 1)) {
          visited.add(node + 1);
          next.add(node + 1);
        }

        if (node - 1 > 0 && !visited.contains(node - 1)) {
          visited.add(node - 1);
          next.add(node - 1);
        }
      }

      curr = next;
      steps++;
    }

    return -1;
  }
}
