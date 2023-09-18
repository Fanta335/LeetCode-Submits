import java.util.*;

class RowComparator implements Comparator<int[]> {
  @Override
  public int compare(int[] a, int[] b) {
    if (a[1] == b[1]) {
      return a[0] - b[0];
    }
    return a[1] - b[1];
  }
}


class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
    int m = mat.length;
    int[][] counts = new int[m][2];
    for (int i = 0; i < m; i++) {
      int c = 0;
      for (int bin : mat[i]) {
        if (bin == 0) {
          break;
        }
        c += bin;
      }
      counts[i][0] = i;
      counts[i][1] = c;
    }

    RowComparator comparator = new RowComparator();
    PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
    for (int[] count : counts) {
      pq.offer(count);
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll()[0];
    }
    return res;
  }
}
