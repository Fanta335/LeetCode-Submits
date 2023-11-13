import java.util.*;

class Solution {
  private Set<Character> vowelSet =
      new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

  public String sortVowels(String s) {
    int n = s.length();
    PriorityQueue<Character> minHeap = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (vowelSet.contains(ch)) {
        minHeap.offer(ch);
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (vowelSet.contains(ch)) {
        sb.append(minHeap.poll());
      } else {
        sb.append(ch);
      }
    }

    return sb.toString();
  }
}
