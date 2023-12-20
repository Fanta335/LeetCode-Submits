class Solution {
  public int buyChoco(int[] prices, int money) {
    int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

    for (int price : prices) {
      if (price < min) {
        secondMin = min;
        min = price;
      } else if (price < secondMin) {
        secondMin = price;
      }
    }

    int sum = min + secondMin;

    if (sum <= money) {
      return money - (sum);
    }

    return money;
  }
}
