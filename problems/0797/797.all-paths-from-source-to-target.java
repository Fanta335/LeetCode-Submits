import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(graph, res, list, 0);
        return res;
    }

    private void backtrack(int[][] graph, List<List<Integer>> res, List<Integer> list, int i) {
        list.add(i);
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(list));
        } else {
            for (int next : graph[i]) {
                backtrack(graph, res, list, next);
            }
        }
        list.remove(list.size() - 1);
    }
}
// @lc code=end

