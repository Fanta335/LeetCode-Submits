import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), res, 0);
        return res;
    }

    private void backtrack(String s, List<String> currList, List<List<String>> resList, int start) {
        if (currList.size() > 0 && start == s.length()) {
            resList.add(new ArrayList<>(currList));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                if (start == end) {
                    currList.add(Character.toString(s.charAt(start)));
                } else {
                    currList.add(s.substring(start, end + 1));
                }
                backtrack(s, currList, resList, end + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end

