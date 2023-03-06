class Solution {
  public int findKthPositive(int[] arr, int k) {
    int res = 1, i = 0;
    while (k > 0 && i < arr.length) {
      if (res == arr[i]) {
        res++;
        i++;
      } else if (res < arr[i]) {
        res++;
        k--;
      }
    }
    return res + k - 1;
  }
}
