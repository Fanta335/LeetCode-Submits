class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int N = flowerbed.length;
    for (int i = 0; i < N && n > 0; i++) {
      if (flowerbed[Math.max(0, i - 1)] != 1 && flowerbed[i] != 1
          && flowerbed[Math.min(N - 1, i + 1)] != 1) {
        n--;
        i++;
      }
    }
    return n == 0;
  }
}
