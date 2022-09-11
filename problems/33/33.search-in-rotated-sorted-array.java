/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                break;
            }
            int mid = (r - l) / 2 + l;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // Index `l` is at min value.
        if (target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, l, nums.length - 1);
        } else if (target >= nums[0]) {
            return binarySearch(nums, target, 0, l-1);
        } else {
            return -1;
        }
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

