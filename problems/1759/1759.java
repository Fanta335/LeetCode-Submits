class Solution {
  public int countHomogenous(String s) {
    int mod = (int) 1e9 + 7;
    long count = 0;
    int N = s.length(), start = 0;

    while (start < N) {
      char curr = s.charAt(start);
      int end = start;
      while (end < N && curr == s.charAt(end)) {
        end++;
      }
      long len = end - start;
      count = (count + ((len * (len + 1) / 2) % mod)) % mod;
      start = end;
    }

    return (int) (count % mod);
  }
}
