class Solution {
  public int[] findArray(int[] pref) {
    int N = pref.length;
    int[] arr = new int[N];
    arr[0] = pref[0];

    for (int i = 1; i < N; i++) {
      arr[i] = pref[i - 1] ^ pref[i];
    }

    return arr;
  }
}
