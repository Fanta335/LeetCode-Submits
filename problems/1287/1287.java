class Solution {
  public int findSpecialInteger(int[] arr) {
    int n = arr.length;

    for (int l = 0, r = n / 4; r < n; l++, r++) {
      if (arr[l] == arr[r]) {
        return arr[l];
      }
    }

    return -1;
  }
}
