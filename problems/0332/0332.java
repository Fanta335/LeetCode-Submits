import java.util.*;

class DictComparator implements Comparator<String> {
  @Override
  public int compare(String a, String b) {
    // It can be assumed that `a.length() === b.length()` and `a != b`.
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) - b.charAt(i) == 0) {
        continue;
      } else if (a.charAt(i) - b.charAt(i) < 0) {
        return -1;
      } else {
        return 1;
      }
    }
    return 0;
  }
}


class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    for (List<String> ticket : tickets) {
      String from = ticket.get(0), to = ticket.get(1);
      if (!graph.containsKey(from)) {
        Comparator<String> comparator = new DictComparator();
        graph.put(from, new PriorityQueue<>(comparator));
      }
      graph.get(from).offer(to);
    }
    List<String> res = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    stack.push("JFK");
    while (!stack.isEmpty()) {
      while (graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()) {
        stack.push(graph.get(stack.peek()).poll());
      }
      res.add(0, stack.pop());
    }
    return res;
  }
}
