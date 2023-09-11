import java.util.*;

class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < groupSizes.length; i++) {
      int s = groupSizes[i];
      if (!map.containsKey(s)) {
        map.put(s, new ArrayList<>());
      }
      List<Integer> curr = map.get(s);
      curr.add(i);
      if (curr.size() == s) {
        res.add(new ArrayList<>(curr));
        curr.clear();
      }
    }

    return res;
  }
}
