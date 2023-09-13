class TrieNode {
  char val;
  TrieNode[] children;
  boolean isEndOfWord;

  public TrieNode(char val) {
    this.val = val;
    this.children = new TrieNode[26];
  }
}


class Trie {
  TrieNode[] initials;

  public Trie() {
    initials = new TrieNode[26];
  }

  public void insert(String word) {
    if (word.length() == 0) {
      return;
    }
    char init = word.charAt(0);
    if (initials[init - 'a'] == null) {
      initials[init - 'a'] = new TrieNode(init);
    }
    TrieNode curr = initials[init - 'a'];
    for (int i = 1; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode next = curr.children[ch - 'a'];
      if (next == null) {
        next = new TrieNode(ch);
      }
      curr.children[ch - 'a'] = next;
      curr = next;
    }
    curr.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode curr = initials[word.charAt(0) - 'a'];
    for (int i = 1; i < word.length(); i++) {
      if (curr == null) {
        return false;
      }
      curr = curr.children[word.charAt(i) - 'a'];
    }
    return curr != null && curr.isEndOfWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode curr = initials[prefix.charAt(0) - 'a'];
    for (int i = 1; i < prefix.length(); i++) {
      if (curr == null) {
        return false;
      }
      curr = curr.children[prefix.charAt(i) - 'a'];
    }
    return curr != null;
  }
}
