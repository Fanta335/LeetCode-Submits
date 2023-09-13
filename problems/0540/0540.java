class Solution {
  public int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int l = 0, r = nums.length - 1;
    while (r - l >= 3) {
      int mid = (r - l) / 2 + l;
      if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
        return nums[mid];
      } else if (nums[mid] == nums[mid - 1]) {
        if (mid % 2 == 0) {
          r = mid - 2;
        } else {
          l = mid + 1;
        }
      } else {
        if (mid % 2 == 0) {
          l = mid + 2;
        } else {
          r = mid - 1;
        }
      }
    }
    if (l == r) {
      return nums[l];
    }
    return nums[l] == nums[l + 1] ? nums[r] : nums[l];
  }
}
