class Solution {
  public int numIdenticalPairs(int[] nums) {
    int res = 0;
    int[] counts = new int[101];

    for (int num : nums) {
      res += counts[num];
      counts[num]++;
    }

    return res;
  }
}
