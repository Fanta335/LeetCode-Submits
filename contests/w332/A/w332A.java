class Solution {
  public long findTheArrayConcVal(int[] nums) {
    long total = 0;
    int l = 0, r = nums.length - 1;
    while (l < r) {
      long con = Long.valueOf(String.valueOf(nums[l++]) + String.valueOf(nums[r--]));
      total += con;
    }
    return l == r ? total + nums[l] : total;
  }
}
