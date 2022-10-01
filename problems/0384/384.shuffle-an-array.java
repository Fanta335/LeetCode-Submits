/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {
    int[] nums;

    public Solution(int[] arr) {
        this.nums = arr;
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = 0; i < res.length; i++) {
            int target = i + (int) Math.floor(Math.random() * (res.length - i));
            swap(res, i, target);
        }
        return res;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset(); int[] param_2 = obj.shuffle();
 */
// @lc code=end

