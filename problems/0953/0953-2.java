class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    for (int i = 0; i < words.length - 1; i++) {
      String a = words[i], b = words[i + 1];
      for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
        int idxA = order.indexOf(a.charAt(j)), idxB = order.indexOf(b.charAt(j));
        if (idxA == idxB) {
          if (j == Math.min(a.length(), b.length()) && a.length() - 1 > j) {
            return false;
          }
          continue;
        }
        if (idxA < idxB) {
          break;
        }
        if (idxA > idxB) {
          return false;
        }
      }
    }
    return true;
  }
}
