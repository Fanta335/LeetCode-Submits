/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};

        if (nums.length == 0) {
            return res;
        }

        int l = 0;
        int r = nums.length - 1;
        int mid = (r - l) / 2 + l;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (nums[mid] != target) {
            return res;
        }

        res[0] = findLeft(nums, target, l, mid);
        res[1] = findRight(nums, target, mid, r);

        return res;
    }

    private int findLeft(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int findRight(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid + 1] == target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
// @lc code=end

