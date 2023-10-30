import java.util.*;

class Solution {
  public int[] sortByBits(int[] arr) {
    int N = arr.length;
    Integer[] integerArr = new Integer[N];
    for (int i = 0; i < N; i++) {
      integerArr[i] = arr[i];
    }

    Arrays.sort(integerArr);
    Arrays.sort(integerArr, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));

    int[] res = new int[N];
    for (int i = 0; i < N; i++) {
      res[i] = integerArr[i];
    }
    return res;
  }
}
