import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    class Node {
        int num;
        int count;

        public Node(int num) {
            this.num = num;
            this.count = 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        Map<Integer, Node> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new Node(num));
            }
            Node node = map.get(num);
            node.count++;
        }
        for (Node node : map.values()) {
            maxHeap.offer(node);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().num;
        }
        return res;
    }
}
// @lc code=end

