import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=929 lang=java
 *
 * [929] Unique Email Addresses
 */

// @lc code=start
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String parsed = parseEmail(email);
            set.add(parsed);
        }
        return set.size();
    }

    private String parseEmail(String email) {
        StringBuilder sb = new StringBuilder();
        boolean isDomain = false;
        boolean afterPlus = false;
        for (char c : email.toCharArray()) {
            if (!isDomain) {
                if (c == '@') {
                    isDomain = true;
                } else if (afterPlus || c == '.') {
                    continue;
                } else if (c == '+') {
                    afterPlus = true;
                    continue;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end

