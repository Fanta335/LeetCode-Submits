class Solution {
  private int signFunc(int x) {
    if (x > 0) {
      return 1;
    } else if (x < 0) {
      return -1;
    } else {
      return 0;
    }
  }

  public int arraySign(int[] nums) {
    int sign = 1;
    for (int num : nums) {
      if (num > 0) {
        sign *= 1;
      } else if (num < 0) {
        sign *= -1;
      } else {
        sign = 0;
      }
    }
    return signFunc(sign);
  }
}
