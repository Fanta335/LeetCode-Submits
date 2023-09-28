class Solution {
  public int[] sortArrayByParity(int[] nums) {
    int e = 1, o = 0;
    while (e < nums.length) {
      while (e < nums.length - 1 && nums[e] % 2 != 0) {
        e++;
      }
      while (o < e && nums[o] % 2 == 0) {
        o++;
      }
      int temp = nums[e];
      nums[e] = nums[o];
      nums[o] = temp;
    }
    return nums;
  }
}
