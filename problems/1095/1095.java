/**
 * // This is MountainArray's API interface. // You should not implement it, or speculate about its
 * implementation interface MountainArray { public int get(int index) {} public int length() {} }
 */
interface MountainArray {
  public default int get(int index) {
    return 1;
  }

  public default int length() {
    return 1;
  }
}


class Solution {
  public int findInMountainArray(int target, MountainArray mountainArr) {
    int N = mountainArr.length(), res = -1;

    // find index of max value in MountainArray.
    int peakIdx = binarySearchPeakIdx(0, N - 1, mountainArr);

    if (mountainArr.get(peakIdx) == target) {
      return peakIdx;
    }

    // find target in ASC.
    int l = 0, r = peakIdx - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      int val = mountainArr.get(mid);
      if (val == target) {
        return mid;
      } else if (val < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    // find target in DESC.
    if (res == -1) {
      l = peakIdx + 1;
      r = N - 1;
      while (l <= r) {
        int mid = (l + r) / 2;
        int val = mountainArr.get(mid);
        if (val == target) {
          return mid;
        } else if (val < target) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }

    return res;
  }

  private int binarySearchPeakIdx(int l, int r, MountainArray mountainArr) {
    if (r < l) {
      return -1;
    }
    int mid = (l + r) / 2;
    int a = mountainArr.get(mid - 1), b = mountainArr.get(mid), c = mountainArr.get(mid + 1);
    if (a < b && b > c) {
      return mid;
    } else if (a < b) {
      return binarySearchPeakIdx(mid, r, mountainArr);
    } else {
      return binarySearchPeakIdx(l, mid, mountainArr);
    }
  }
}
