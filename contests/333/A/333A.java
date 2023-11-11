import java.util.LinkedList;
import java.util.List;

class Solution {
  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    List<int[]> list = new LinkedList<>();
    int i1 = 0, i2 = 0;
    while (i1 < nums1.length && i2 < nums2.length) {
      int[] p1 = nums1[i1], p2 = nums2[i2];
      if (p1[0] == p2[0]) {
        list.add(new int[] {p1[0], p1[1] + p2[1]});
        i1++;
        i2++;
      } else if (p1[0] < p2[0]) {
        list.add(new int[] {p1[0], p1[1]});
        i1++;
      } else if (p1[0] > p2[0]) {
        list.add(new int[] {p2[0], p2[1]});
        i2++;
      }
    }
    while (i1 < nums1.length) {
      list.add(new int[] {nums1[i1][0], nums1[i1][1]});
      i1++;
    }
    while (i2 < nums2.length) {
      list.add(new int[] {nums2[i2][0], nums2[i2][1]});
      i2++;
    }

    int[][] res = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}
