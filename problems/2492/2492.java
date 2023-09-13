import java.util.*;

class Solution {
  public int minScore(int n, int[][] roads) {
    Map<Integer, List<List<Integer>>> adj = new HashMap<>();

    for (int[] node : roads) {
      adj.computeIfAbsent(node[0], k -> new ArrayList<>()).add(Arrays.asList(node[1], node[2]));
      adj.computeIfAbsent(node[1], k -> new ArrayList<>()).add(Arrays.asList(node[0], node[2]));
    }

    int res = Integer.MAX_VALUE;
    boolean[] visited = new boolean[n + 1];
    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    visited[1] = true;
    while (!q.isEmpty()) {
      int currCity = q.poll();
      List<List<Integer>> adjCities = adj.get(currCity);
      for (List<Integer> city : adjCities) {
        if (!visited[city.get(0)]) {
          visited[city.get(0)] = true;
          q.offer(city.get(0));
        }
        res = Math.min(res, city.get(1));
      }
    }
    return res;
  }
}
