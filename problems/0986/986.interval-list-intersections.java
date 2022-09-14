import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();

        int i1 = 0, i2 = 0;

        while (i1 < firstList.length && i2 < secondList.length) {
            int[] l1 = firstList[i1];
            int[] l2 = secondList[i2];
            int maxStart = Math.max(l1[0], l2[0]);
            int minEnd = Math.min(l1[1], l2[1]);
            if (maxStart > l1[1]) {
                i1++;
                continue;
            }
            if (maxStart > l2[1]) {
                i2++;
                continue;
            }
            if (minEnd == l1[1]) {
                i1++;
            }
            if (minEnd == l2[1]) {
                i2++;
            }
            res.add(new int[] {maxStart, minEnd});
        }


        int[][] arrayRes = new int[res.size()][2];
        for (int i = 0; i < arrayRes.length; i++) {
            arrayRes[i] = res.get(i);
        }
        return arrayRes;
    }
}
// @lc code=end

