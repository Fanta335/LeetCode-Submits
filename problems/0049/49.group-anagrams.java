import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            String strKey = Arrays.toString(count);
            if (!map.containsKey(strKey)) {
                map.put(strKey, new ArrayList<>());
            }
            map.get(strKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

