class Solution {
  public long minimumSteps(String s) {
    int n = s.length();
    int[] numOfZeroFromRight = new int[n + 1];
    numOfZeroFromRight[n] = 0;
    for (int i = n - 1; i >= 0; i--) {
      numOfZeroFromRight[i] = numOfZeroFromRight[i + 1];
      if (s.charAt(i) == '0') {
        numOfZeroFromRight[i]++;
      }
    }

    long ans = 0;

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '1') {
        ans += numOfZeroFromRight[i];
      }
    }

    return ans;
  }
}
