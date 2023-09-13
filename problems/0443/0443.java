class Solution {
  public int compress(char[] chars) {
    int N = chars.length, res = 1, count = 1;
    char prev = chars[0];

    for (int i = 1; i < N; i++) {
      char curr = chars[i];
      if (curr == prev) {
        count++;
      } else {
        if (count > 1) {
          chars[res - 1] = prev;
          String str = String.valueOf(count);
          for (int j = 0; j < str.length(); j++) {
            chars[res++] = str.charAt(j);
          }
        } else {
          chars[res - 1] = prev;
        }
        res++;
        count = 1;
        prev = curr;
      }
    }
    chars[res - 1] = chars[N - 1];
    if (count > 1) {
      String str = String.valueOf(count);
      for (int j = 0; j < str.length(); j++) {
        chars[res++] = str.charAt(j);
      }
    }

    return res;
  }
}
