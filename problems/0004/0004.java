class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    int[] cache = new int[n + m];
    int i = 0, j = 0;
    while (i < n || j < m) {
      if (i == n) {
        cache[i + j] = nums2[j++];
      } else if (j == m) {
        cache[i + j] = nums1[i++];
      } else {
        cache[i + j] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
      }
    }
    if (cache.length % 2 == 0) {
      return (cache[(cache.length - 1) / 2] + cache[(cache.length - 1) / 2 + 1]) / (double) 2;
    } else {
      return (double) cache[(cache.length - 1) / 2];
    }
  }
}
