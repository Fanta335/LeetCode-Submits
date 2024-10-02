import java.util.*;

class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int n = arr.length;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : arr) {
      minHeap.add(num);
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    int currRank = 1;
    while (!minHeap.isEmpty()) {
      int currEl = minHeap.poll();
      if (!map.containsKey(currEl)) {
        map.put(currEl, currRank++);
      }
    }
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = map.get(arr[i]);
    }
    return res;
  }
}
