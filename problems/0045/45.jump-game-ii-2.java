/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int reach = 0;
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (reach < nums.length - i - 1) {
                int next = i;
                for (int j = i; j <= i + reach; j++) {
                    if (nums[next] - (j - next) < nums[j]) {
                        next = j;
                    }
                }
                reach = nums[next];
                i = next;
                count++;
            }
            i++;
            reach--;
        }
        return count;
    }
}
// @lc code=end

