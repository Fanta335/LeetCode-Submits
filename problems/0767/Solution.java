import java.util.*;

class Solution {
  public String reorganizeString(String s) {
    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      counts[c - 'a']++;
    }
    int maxCount = 0;
    for (int count : counts) {
      maxCount = Math.max(maxCount, count);
    }
    if (s.length() % 2 == 0) {
      if (maxCount > s.length() / 2) {
        return "";
      }
    } else {
      if (maxCount > s.length() / 2 + 1) {
        return "";
      }
    }

    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0) {
        maxHeap.offer(new int[] {i, counts[i]});
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      int[] curr = maxHeap.poll();
      char ch = (char) (curr[0] + 'a');
      if (sb.length() == 0 || sb.charAt(sb.length() - 1) != ch) {
        sb.append(ch);
        curr[1]--;
        if (curr[1] > 0) {
          maxHeap.offer(curr);
        }
      } else {
        int[] next = maxHeap.poll();
        sb.append((char) (next[0] + 'a'));
        next[1]--;
        if (next[1] > 0) {
          maxHeap.offer(next);
        }
        maxHeap.offer(curr);
      }
    }

    return sb.toString();
  }
}
