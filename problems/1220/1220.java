import java.util.*;

class Solution {
  int mod = (int) 1e9 + 7;
  char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};

  public int countVowelPermutation(int n) {
    if (n == 1) {
      return 5;
    }

    Map<Character, Long> currCounts = new HashMap<>();
    Map<Character, Long> prevCounts = new HashMap<>();

    for (char vowel : vowels) {
      prevCounts.put(vowel, 1L);
    }

    for (int i = 1; i < n; i++) {
      for (char vowel : vowels) {
        if (vowel == 'a') {
          currCounts.put(vowel, (prevCounts.get('e')) % mod);
        } else if (vowel == 'e') {
          currCounts.put(vowel, (prevCounts.get('a') + prevCounts.get('i')) % mod);
        } else if (vowel == 'i') {
          long currSum = 0;
          for (Map.Entry<Character, Long> entry : prevCounts.entrySet()) {
            if (entry.getKey() != 'i') {
              currSum = (currSum + entry.getValue()) % mod;
            }
          }
          currCounts.put(vowel, currSum);
        } else if (vowel == 'o') {
          currCounts.put(vowel, (prevCounts.get('i') + prevCounts.get('u')) % mod);
        } else if (vowel == 'u') {
          currCounts.put(vowel, (prevCounts.get('a')) % mod);
        }
      }

      for (char vowel : vowels) {
        prevCounts.put(vowel, currCounts.get(vowel));
      }
    }


    long total = 0;
    for (long count : currCounts.values()) {
      total = (total + count) % mod;
    }

    return (int) total % mod;
  }
}
