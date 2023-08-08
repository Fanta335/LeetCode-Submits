class Solution {
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    if (nums[l] <= nums[r]) {
      return binarySearch(nums, target, l, r);
    }
    while (l <= r) {
      if (nums[l] <= nums[r]) {
        break;
      }
      int mid = (l + r) / 2;
      if (nums[mid] >= nums[l]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    int start = l;
    l = 0;
    r = nums.length - 1;
    if (nums[l] <= target) {
      return binarySearch(nums, target, l, start - 1);
    } else {
      return binarySearch(nums, target, start, r);
    }
  }

  private int binarySearch(int[] nums, int target, int l, int r) {
    while (l <= r) {
      int mid = (l + r) / 2;
      System.out.println(mid);
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return -1;
  }
}
