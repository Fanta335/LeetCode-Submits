import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public boolean startsWithVowel(String s) {
    return vowels.contains(s.charAt(0)) && vowels.contains(s.charAt(s.length() - 1));
  }

  public int[] vowelStrings(String[] words, int[][] queries) {
    int N = words.length;
    int[] dp = new int[N + 1];
    dp[0] = 0;
    for (int i = 0; i < N; i++) {
      String curr = words[i];
      if (startsWithVowel(curr)) {
        dp[i + 1] = dp[i] + 1;
      } else {
        dp[i + 1] = dp[i];
      }
    }
    int M = queries.length;
    int[] res = new int[M];
    for (int i = 0; i < M; i++) {
      int[] q = queries[i];
      int sum = dp[q[1] + 1] - dp[q[0]];
      res[i] = sum;
    }
    return res;
  }
}
