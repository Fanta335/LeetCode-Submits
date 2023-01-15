class Solution {
  public int differenceOfSum(int[] nums) {
    int elsum = 0, digsum = 0;
    for (int num : nums) {
      elsum += num;
      while (num > 0) {
        digsum += num % 10;
        num /= 10;
      }
    }
    return Math.abs(elsum - digsum);
  }
}
