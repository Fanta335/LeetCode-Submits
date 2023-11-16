import java.util.*;

class Solution {
  public String findDifferentBinaryString(String[] nums) {
    int n = nums.length;
    Set<Integer> set = new HashSet<>();
    for (String bin : nums) {
      int num = Integer.parseInt(bin, 2);
      set.add(num);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= n; i++) {
      if (!set.contains(i)) {
        sb.append(Integer.toBinaryString(i));
        break;
      }
    }

    while (sb.length() < n) {
      sb.insert(0, "0");
    }

    return sb.toString();
  }
}
