class Solution {
  int res;

  public int maxScoreWords(String[] words, char[] letters, int[] score) {
    int[] counts = new int[26];
    for (int i = 0; i < letters.length; i++) {
      counts[letters[i] - 'a']++;
    }

    res = 0;

    helper(words, counts, score, 0, 0);

    return res;
  }

  private void helper(String[] words, int[] counts, int[] score, int i, int curr) {
    for (int j = i; j < words.length; j++) {
      String word = words[j];

      boolean skip = false;

      for (int k = 0; k < word.length(); k++) {
        char ch = word.charAt(k);

        if (counts[ch - 'a'] == 0) {
          System.err.println("skip");
          skip = true;

          for (int l = k - 1; l >= 0; l--) {
            counts[word.charAt(l) - 'a']++;
            curr -= score[word.charAt(l) - 'a'];
          }

          break;
        }

        counts[ch - 'a']--;
        curr += score[ch - 'a'];
      }

      if (!skip) {
        res = Math.max(res, curr);
        helper(words, counts, score, j + 1, curr);

        for (int k = word.length() - 1; k >= 0; k--) {
          counts[word.charAt(k) - 'a']++;
          curr -= score[word.charAt(k) - 'a'];
        }
      }
    }
  }
}
