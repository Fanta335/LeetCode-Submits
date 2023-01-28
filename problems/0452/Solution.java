import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int N = points.length;
        int count = 1;
        Arrays.sort(points, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        int currMax = points[0][1];
        for (int i = 1; i < N; i++) {
            int[] p = points[i];
            System.out.println(Arrays.toString(p));
            if (currMax < p[0]) {
                count++;
                currMax = p[1];
            } else {
                currMax = Math.min(currMax, p[1]);
            }
        }
        return count;
    }
}
