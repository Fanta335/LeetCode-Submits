import java.util.HashMap;
import java.util.Map;

class Solution {
  public int totalFruit(int[] fruits) {
    int N = fruits.length;
    int maxSum = 0;
    int currSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int l = 0, r = 0; r < N; r++) {
      int rType = fruits[r];
      if (map.size() < 2) {
        map.put(rType, map.getOrDefault(rType, 0) + 1);
        currSum++;
      } else {
        if (map.containsKey(rType)) {
          map.put(rType, map.get(rType) + 1);
          currSum++;
        } else {
          while (map.size() > 1) {
            int lType = fruits[l++];
            map.put(lType, map.get(lType) - 1);
            currSum--;
            if (map.get(lType) == 0) {
              map.remove(lType);
            }
          }
          map.put(rType, map.getOrDefault(rType, 0) + 1);
          currSum++;
        }
      }
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}
