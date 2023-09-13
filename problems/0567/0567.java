import java.util.Arrays;

class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      freq1[s1.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s2.length(); i++) {
      if (freq1[s2.charAt(i) - 'a'] > 0) {
        for (int j = i; j < Math.min(i + s1.length(), s2.length()); j++) {
          freq2[s2.charAt(j) - 'a']++;
          if (Arrays.equals(freq1, freq2)) {
            return true;
          }
        }
        Arrays.fill(freq2, 0);
      }
    }
    return false;
  }
}
