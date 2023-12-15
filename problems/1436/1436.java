import java.util.*;

class Solution {
  public String destCity(List<List<String>> paths) {
    Map<String, String> map = new HashMap<>();

    for (List<String> path : paths) {
      String from = path.get(0), to = path.get(1);

      map.put(from, to);
    }

    String curr = paths.get(0).get(0);
    while (map.get(curr) != null) {
      curr = map.get(curr);
    }
    return curr;
  }
}
