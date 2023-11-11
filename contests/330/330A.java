import java.util.HashSet;
import java.util.Set;

class Solution {
  public void helper(Set<Integer> set, int num) {
    if (num <= 2) {
      return;
    }
    for (int i = 1; i <= num; i++) {
      if (num % i == 1) {
        set.add(i);
        helper(set, i);
      }
    }
  }

  public int distinctIntegers(int n) {
    Set<Integer> set = new HashSet<>();
    helper(set, n);
    return set.size() + 1;
  }
}
