class TrieNode {
  public TrieNode[] children;
  public boolean isEndOfWord;

  public TrieNode() {
    this.children = new TrieNode[26];
  }
}


class WordDictionary {
  public TrieNode root;

  public WordDictionary() {
    this.root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode curr = this.root;
    for (char ch : word.toCharArray()) {
      if (curr.children[ch - 'a'] == null) {
        curr.children[ch - 'a'] = new TrieNode();
      }
      curr = curr.children[ch - 'a'];
    }
    curr.isEndOfWord = true;
  }

  public boolean search(String word) {
    return match(word.toCharArray(), 0, this.root);
  }

  private boolean match(char[] chars, int k, TrieNode node) {
    if (k == chars.length) {
      return node.isEndOfWord;
    }
    if (chars[k] == '.') {
      for (int i = 0; i < node.children.length; i++) {
        if (node.children[i] != null && match(chars, k + 1, node.children[i])) {
          return true;
        }
      }
    } else {
      return node.children[chars[k] - 'a'] != null
          && match(chars, k + 1, node.children[chars[k] - 'a']);
    }
    return false;
  }
}
