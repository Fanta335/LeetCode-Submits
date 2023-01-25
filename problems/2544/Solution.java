import java.util.ArrayList;
import java.util.List;

class Solution {
  public int alternateDigitSum(int n) {
    List<Integer> nums = new ArrayList<>();
    while (n > 0) {
      nums.add(n % 10);
      n /= 10;
    }
    int sum = 0;
    boolean positive = true;
    for (int i = nums.size() - 1; i >= 0; i--) {
      sum += positive ? nums.get(i) : -1 * nums.get(i);
      positive = !positive;
    }

    return sum;
  }
}
