import java.util.*;

class Solution {
  private final int THRESHOLD = 2;

  public List<String> findHighAccessEmployees(List<List<String>> access_times) {
    List<String> res = new ArrayList<>();
    Map<String, List<Integer>> map = new HashMap<>();

    for (List<String> accessTime : access_times) {
      String name = accessTime.get(0);
      String time = accessTime.get(1);

      map.computeIfAbsent(name, k -> new ArrayList<>()).add(Integer.valueOf(time));
    }

    for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
      String name = entry.getKey();
      List<Integer> times = entry.getValue();
      Collections.sort(times);

      int len = times.size();

      if (len <= THRESHOLD) {
        continue;
      }

      for (int i = 0; i < len - THRESHOLD; i++) {
        int time1 = times.get(i);
        int time2 = times.get(i + THRESHOLD);

        if (time2 - time1 < 100) {
          res.add(name);
          break;
        }
      }
    }

    return res;
  }
}
