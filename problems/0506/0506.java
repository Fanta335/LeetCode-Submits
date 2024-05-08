import java.util.*;

class Solution {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    for (int i = 0; i < n; i++) {
      maxHeap.add(score[i]);
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    while (maxHeap.size() > 0) {
      map.put(maxHeap.poll(), n - maxHeap.size());
    }

    String[] res = new String[n];

    for (int i = 0; i < n; i++) {
      int rank = map.get(score[i]);

      if (rank == 1) {
        res[i] = "Gold Medal";
      } else if (rank == 2) {
        res[i] = "Silver Medal";
      } else if (rank == 3) {
        res[i] = "Bronze Medal";
      } else {
        res[i] = String.valueOf(rank);
      }
    }

    return res;
  }
}
