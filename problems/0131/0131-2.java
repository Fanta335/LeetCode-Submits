import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  private boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  private void dfs(int start, List<List<String>> res, List<String> currList, String s) {
    if (start >= s.length()) {
      res.add(new ArrayList<>(currList));
      return;
    }
    for (int end = start; end < s.length(); end++) {
      if (isPalindrome(s, start, end)) {
        currList.add(s.substring(start, end + 1));
        dfs(end + 1, res, currList, s);
        currList.remove(currList.size() - 1);
      }
    }
  }


  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    dfs(0, res, new ArrayList<>(), s);
    return res;
  }
}
