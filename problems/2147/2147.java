class Solution {
  int MOD = (int) 1e9 + 7;

  public int numberOfWays(String corridor) {
    long count = 0;
    int n = corridor.length(), currSeats = 0, plantsBetweenSeats = 0;

    for (int i = 0; i < n; i++) {
      char ch = corridor.charAt(i);
      if (ch == 'S') {
        currSeats++;
      }

      if (currSeats == 2) {
        if (count == 0) {
          count = 1;
        } else {
          count = (count * (plantsBetweenSeats + 1)) % MOD;
          plantsBetweenSeats = 0;
        }

        int j = i + 1;
        while (j < n && corridor.charAt(j++) == 'P') {
          plantsBetweenSeats++;
        }
        i += plantsBetweenSeats;

        currSeats = 0;
      }
    }

    return currSeats == 0 ? (int) count % MOD : 0;
  }
}
