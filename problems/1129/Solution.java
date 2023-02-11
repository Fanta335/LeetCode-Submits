import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    Map<Integer, List<List<Integer>>> adj = new HashMap<>();
    for (int[] edge : redEdges) {
      adj.computeIfAbsent(edge[0], k -> new ArrayList<List<Integer>>())
          .add(Arrays.asList(edge[1], 0));
    }
    for (int[] edge : blueEdges) {
      adj.computeIfAbsent(edge[0], k -> new ArrayList<List<Integer>>())
          .add(Arrays.asList(edge[1], 1));
    }

    int[] answer = new int[n];
    Arrays.fill(answer, -1);
    boolean[][] visit = new boolean[n][2];
    Queue<int[]> q = new LinkedList<>();

    q.offer(new int[] {0, 0, -1});
    answer[0] = 0;
    visit[0][1] = visit[0][0] = true;

    while (!q.isEmpty()) {
      int[] element = q.poll();
      int node = element[0], steps = element[1], prevColor = element[2];

      if (!adj.containsKey(node)) {
        continue;
      }

      for (List<Integer> nei : adj.get(node)) {
        int neighbor = nei.get(0);
        int color = nei.get(1);
        if (!visit[neighbor][color] && color != prevColor) {
          if (answer[neighbor] == -1) {
            answer[neighbor] = 1 + steps;
          }
          visit[neighbor][color] = true;
          q.offer(new int[] {neighbor, 1 + steps, color});
        }
      }
    }

    return answer;
  }
}
