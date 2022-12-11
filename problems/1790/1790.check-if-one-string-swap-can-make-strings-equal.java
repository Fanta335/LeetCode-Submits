import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1790 lang=java
 *
 * [1790] Check if One String Swap Can Make Strings Equal
 */

// @lc code=start
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        Map<Character, Set<Integer>> map1 = generateMap(s1);
        Map<Character, Set<Integer>> map2 = generateMap(s2);
        int count = 0;
        for (Character ch : map1.keySet()) {
            if (!map2.containsKey(ch) || map1.get(ch).size() != map2.get(ch).size() || count > 2) {
                return false;
            }
            for (Integer idx : map1.get(ch)) {
                if (!map2.get(ch).contains(idx)) {
                    count++;
                }
            }
        }
        return count <= 2;
    }

    private Map<Character, Set<Integer>> generateMap(String str) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), new HashSet<>());
            }
            map.get(str.charAt(i)).add(i);
        }
        return map;
    }
}
// @lc code=end

