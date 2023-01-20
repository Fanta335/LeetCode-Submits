public class Solution {
  public int countDigits(int num) {
    int count = 0;
    int curr = num;
    while (curr > 0) {
      int digit = curr % 10;
      if (num % digit == 0) {
        count++;
      }
      curr /= 10;
    }
    return count;
  }
}
