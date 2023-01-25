import java.util.Arrays;

class Solution {
  public int[][] sortTheStudents(int[][] score, int k) {
    Arrays.sort(score, (int[] a, int[] b) -> b[k] - a[k]);
    return score;
  }
}
