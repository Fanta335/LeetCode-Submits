import java.util.ArrayList;
import java.util.List;

class Solution {
  int N;
  String s;

  private void backtrack(List<String> res, StringBuilder cur, int idx, int dots) {
    if (dots == 4 && idx < N) {
      return;
    }
    if (dots == 4 && idx == N) {
      res.add(cur.substring(0, cur.length() - 1));
      return;
    }
    for (int i = idx; i < N; i++) {
      String strNum = s.substring(idx, i + 1);
      if (strNum.length() > 1 && strNum.charAt(0) == '0') {
        break;
      }
      if (Integer.valueOf(strNum) > 255) {
        break;
      }
      cur.append(strNum + ".");
      backtrack(res, cur, i + 1, dots + 1);
      cur.delete(cur.length() - strNum.length() - 1, cur.length());
    }
  }

  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    this.N = s.length();
    this.s = s;
    backtrack(res, new StringBuilder(), 0, 0);
    return res;
  }
}
