class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int N = gas.length;
    int currMin = 0;
    int sum = 0;
    int res = 0;
    for (int i = 0; i < N; i++) {
      sum += gas[i] - cost[i];
      if (currMin > sum) {
        currMin = sum;
        res = (i + 1) % N;
      }
    }
    return sum < 0 ? -1 : res;
  }
}
