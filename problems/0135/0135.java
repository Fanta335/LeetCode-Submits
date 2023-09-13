import java.util.*;

// class Solution {
// public int candy(int[] ratings) {
// int[] counts = new int[ratings.length];
// Arrays.fill(counts, 1);
// for (int i = 1; i < ratings.length; i++) {
// if (ratings[i - 1] > ratings[i]) {
// for (int j = i; j > 0; j--) {
// if (ratings[j - 1] <= ratings[j] || counts[j - 1] > counts[j]) {
// break;
// }
// counts[j - 1]++;
// }
// }
// if (ratings[i - 1] < ratings[i]) {
// counts[i] = counts[i-1] + 1;
// }
// }

// int sum = 0;
// for (int c : counts) {
// sum += c;
// }
// return sum;
// }
// }


class Solution {
  public int candy(int[] ratings) {
    int[] counts = new int[ratings.length];
    Arrays.fill(counts, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        counts[i] = counts[i - 1] + 1;
      }
    }
    for (int i = ratings.length - 1; i > 0; i--) {
      if (ratings[i] < ratings[i - 1]) {
        counts[i - 1] = Math.max(counts[i - 1], counts[i] + 1);
      }
    }
    int sum = 0;
    for (int c : counts) {
      sum += c;
    }
    return sum;
  }

}
