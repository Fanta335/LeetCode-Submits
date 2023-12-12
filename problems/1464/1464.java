class Solution {
  public int maxProduct(int[] nums) {
    int num1 = 0, num2 = 0;

    for (int num : nums) {
      if (num1 < num) {
        num2 = num1;
        num1 = num;
      } else if (num2 < num) {
        num2 = num;
      }
    }

    return (num1 - 1) * (num2 - 1);
  }
}
