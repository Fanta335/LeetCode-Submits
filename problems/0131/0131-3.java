import java.util.*;

class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    dfs(s, 0, res, new ArrayList<>());
    return res;
  }

  private void dfs(String s, int i, List<List<String>> res, List<String> curr) {
    if (i == s.length()) {
      res.add(new ArrayList<>(curr));
    }

    for (int j = i; j < s.length(); j++) {
      if (isPalindrome(s, i, j)) {
        curr.add(s.substring(i, j + 1));
        dfs(s, j + 1, res, curr);
        curr.remove(curr.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    while (start < s.length() && end >= 0 && s.charAt(start) == s.charAt(end)) {
      start++;
      end--;
    }
    return start > end;
  }
}
