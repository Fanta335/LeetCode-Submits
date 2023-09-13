import java.util.HashMap;
import java.util.Map;

public class Solution {
  Map<Integer, Integer> mp;

  private void computePrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        mp.put(i, mp.getOrDefault(i, 0) + 1);
        computePrime(num / i);
        return;
      }
    }
    mp.put(num, mp.getOrDefault(num, 0) + 1);
  }

  public int distinctPrimeFactors(int[] nums) {
    mp = new HashMap<>();
    for (int num : nums) {
      computePrime(num);
    }
    return mp.keySet().size();
  }
}
