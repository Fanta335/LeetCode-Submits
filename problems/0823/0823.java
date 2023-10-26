import java.util.*;

class Solution {
  public int numFactoredBinaryTrees(int[] arr) {
    int mod = (int) 1e9 + 7;
    Arrays.sort(arr);
    Map<Integer, Long> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int current = arr[i];
      map.put(current, 1L);

      for (int j = 0; j < i; j++) {
        int left = arr[j];
        if (current % left != 0) {
          continue;
        }

        int right = current / left;
        if (map.containsKey(right)) {
          map.put(current, map.get(current) + map.get(left) * map.get(right));
        }
      }
    }

    long total = 0;
    for (long count : map.values()) {
      total = (total + count) % mod;
    }

    return (int) total;
  }
}
