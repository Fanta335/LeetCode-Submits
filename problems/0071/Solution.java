import java.util.*;

class Solution {
  public String simplifyPath(String path) {
    Deque<String> deque = new LinkedList<>();
    StringBuilder curr = new StringBuilder();
    if (path.charAt(path.length() - 1) != '/') {
      path += "/";
    }
    for (int i = 1; i < path.length(); i++) {
      char ch = path.charAt(i);
      if (ch == '/') {
        String str = curr.toString();
        if (str.equals("..")) {
          if (!deque.isEmpty()) {
            deque.removeLast();
          }
        } else if (curr.length() > 0) {
          if (!str.equals(".")) {
            deque.add(curr.toString());
          }
        }
        curr.setLength(0);
      } else {
        curr.append(ch);
      }
    }
    StringBuilder res = new StringBuilder();
    for (String node : deque) {
      System.out.println(node);
      res.append("/").append(node);
    }
    return res.length() == 0 ? "/" : res.toString();
  }
}
