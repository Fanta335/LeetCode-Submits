import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    char[][] map;

    private void backtrack(String digits, StringBuilder sb, List<String> res, int start) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char letter : map[digits.charAt(start) - '0']) {
            sb.append(letter);
            backtrack(digits, sb, res, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        map = new char[][] {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        backtrack(digits, new StringBuilder(), res, 0);
        return res;
    }
}
// @lc code=end

