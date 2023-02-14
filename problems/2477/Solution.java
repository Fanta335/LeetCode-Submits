import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
  public long minimumFuelCost(int[][] roads, int seats) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] road : roads) {
      adj.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
    }
    long res = 0;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {0, 0, 0});
    while (!q.isEmpty()) {
      int qSize = q.size();
      while (qSize-- > 0) {
        int[] nei = q.poll();
        int city = nei[0], pas = nei[1], fuel = nei[2];
        if (!adj.containsKey(city)) {
          res += fuel;
          continue;
        }
        List<Integer> adjCities = adj.get(city);
        for (int c : adjCities) {
          if (pas == seats) {
            q.offer(new int[] {c, 0, fuel + 1});
          }
        }
      }
    }
    return res;
  }
}
