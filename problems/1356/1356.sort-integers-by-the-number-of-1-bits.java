import java.util.Arrays;

/*
 * @lc app=leetcode id=1356 lang=java
 *
 * [1356] Sort Integers by The Number of 1 Bits
 */

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b
                : Integer.bitCount(a) - Integer.bitCount(b));
        return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

