import java.util.*;

class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    List<String> currWords = new ArrayList<>();
    int numOfChars = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (numOfChars + currWords.size() + word.length() <= maxWidth) {
        currWords.add(word);
        numOfChars += word.length();
      } else {
        String line = generateLine(currWords, numOfChars, new StringBuilder(), maxWidth);
        res.add(line);
        currWords.clear();
        currWords.add(word);
        numOfChars = word.length();
      }
    }

    StringBuilder sb = new StringBuilder();
    for (String word : currWords) {
      sb.append(word).append(' ');
    }
    if (sb.length() > maxWidth) {
      sb.deleteCharAt(sb.length() - 1);
    }
    while (sb.length() < maxWidth) {
      sb.append(' ');
    }
    res.add(sb.toString());
    return res;
  }

  public String generateLine(List<String> currWords, int numOfChars, StringBuilder sb,
      int maxWidth) {
    if (currWords.size() > 1) {
      int spaceLen = (int) Math.ceil((double) (maxWidth - numOfChars) / (currWords.size() - 1));
      for (int i = 0; i < currWords.size() - 1; i++) {
        sb.append(currWords.get(i));
        for (int j = 0; j < spaceLen; j++) {
          sb.append(' ');
        }
      }

      sb.append(currWords.get(currWords.size() - 1));

      int i = sb.length() - 1;
      while (i > 0) {
        if (sb.charAt(i) == ' ') {
          sb.deleteCharAt(i--);
        }
        if (sb.length() == maxWidth) {
          break;
        }
        while (sb.charAt(i) == ' ') {
          i--;
        }
        while (sb.charAt(i) != ' ') {
          i--;
        }
      }
    } else {
      sb.append(currWords.get(0));
      while (sb.length() < maxWidth) {
        sb.append(' ');
      }
    }
    return sb.toString();
  }
}
