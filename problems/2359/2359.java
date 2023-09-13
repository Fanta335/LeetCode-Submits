import java.util.Arrays;

class Solution {
  public int closestMeetingNode(int[] edges, int node1, int node2) {
    int N = edges.length;
    int[] dist1 = new int[N];
    int[] dist2 = new int[N];
    Arrays.fill(dist1, Integer.MAX_VALUE);
    Arrays.fill(dist2, Integer.MAX_VALUE);
    for (int d = 0, curr = node1; d < N && curr != -1; d++) {
      dist1[curr] = Math.min(dist1[curr], d);
      curr = edges[curr];
    }
    for (int d = 0, curr = node2; d < N && curr != -1; d++) {
      dist2[curr] = Math.min(dist2[curr], d);
      curr = edges[curr];
    }
    System.out.println(Arrays.toString(dist1));
    System.out.println(Arrays.toString(dist2));

    int res = -1;
    int minDist = Integer.MAX_VALUE;
    for (int currNode = 0; currNode < N; currNode++) {
      if (minDist > Math.max(dist1[currNode], dist2[currNode])) {
        res = currNode;
        minDist = Math.max(dist1[currNode], dist2[currNode]);
      }
    }

    return res;
  }
}


// class Solution {
// public void bfs(int startNode, int[] edges, int[] dist) {
// int n = edges.length;
// Queue<Integer> q = new LinkedList<>();
// q.offer(startNode);

// Boolean[] visit = new Boolean[n];
// Arrays.fill(visit, Boolean.FALSE);
// dist[startNode] = 0;

// while (!q.isEmpty()) {
// int node = q.poll();

// if (visit[node]) {
// continue;
// }

// visit[node] = true;
// int neighbor = edges[node];
// if (neighbor != -1 && !visit[neighbor]) {
// dist[neighbor] = 1 + dist[node];
// q.offer(neighbor);
// }

// }
// }

// public int closestMeetingNode(int[] edges, int node1, int node2) {
// int n = edges.length;
// int[] dist1 = new int[n], dist2 = new int[n];
// Arrays.fill(dist1, Integer.MAX_VALUE);
// Arrays.fill(dist2, Integer.MAX_VALUE);

// bfs(node1, edges, dist1);
// bfs(node2, edges, dist2);

// int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
// for (int currNode = 0; currNode < n; currNode++) {
// if (minDistTillNow > Math.max(dist1[currNode], dist2[currNode])) {
// minDistNode = currNode;
// minDistTillNow = Math.max(dist1[currNode], dist2[currNode]);
// }
// }

// return minDistNode;
// }
// }
