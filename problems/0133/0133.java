import java.util.*;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}


class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Node res = new Node(node.val);
    Queue<Node> oriQ = new LinkedList<>();
    Queue<Node> cloQ = new LinkedList<>();
    Node[] visited = new Node[101];

    oriQ.offer(node);
    cloQ.offer(res);
    visited[node.val] = res;

    while (!oriQ.isEmpty()) {
      Node ori = oriQ.poll();
      Node clo = cloQ.poll();
      for (Node oriNei : ori.neighbors) {
        if (visited[oriNei.val] == null) {
          oriQ.offer(oriNei);
          Node cloNei = new Node(oriNei.val);
          clo.neighbors.add(cloNei);
          cloQ.offer(cloNei);
          visited[oriNei.val] = cloNei;
        } else {
          clo.neighbors.add(visited[oriNei.val]);
        }
      }
    }

    return res;
  }
}
