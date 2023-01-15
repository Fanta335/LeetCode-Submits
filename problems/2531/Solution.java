import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Character, Integer> generateMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    private void insertAndRemove(Map<Character, Integer> map, char toInsert, char toRemove) {
        map.put(toInsert, map.getOrDefault(toInsert, 0) + 1);
        map.put(toRemove, map.get(toRemove) - 1);
        if (map.get(toRemove) == 0) {
            map.remove(toRemove);
        }
    }

    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = generateMap(word1);
        Map<Character, Integer> map2 = generateMap(word2);
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (map1.containsKey(c1) && map2.containsKey(c2)) {
                    insertAndRemove(map1, c2, c1);
                    insertAndRemove(map2, c1, c2);
                    if (map1.keySet().size() == map2.keySet().size()) {
                        return true;
                    }
                    insertAndRemove(map1, c1, c2);
                    insertAndRemove(map2, c2, c1);
                }
            }
        }


        return false;
    }
}
