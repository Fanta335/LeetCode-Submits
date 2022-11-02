import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest obj = new
 * KthLargest(k, nums); int param_1 = obj.add(val);
 */
// @lc code=end

