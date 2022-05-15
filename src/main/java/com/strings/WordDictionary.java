package com.strings;

public class WordDictionary {
    // word in search consist of  '.' or lower-case English letters.
//    TrieNode trieNode;
//    public WordDictionary() {
//        trieNode = new TrieNode();
//    }
//
//    public void addWord(String word) {
//        trieNode.addWord(word);
//    }
//
//    public boolean search(String word) {
//        return trieNode.search(word);
//    }
//
//
//    private class TrieNode {
//        TrieNode[] trieNodes;
//        boolean isWord;
//
//        public TrieNode() {
//            this.trieNodes = new TrieNode[27];
//            this.isWord = false;
//        }
//
//        public void addWord(String word) {
//            TrieNode cur = this;
//            for(char c : word.toCharArray()) {
//                int index = c - 'a';
//                if (cur.trieNodes[index] == null) {
//                    cur.trieNodes[index] = new TrieNode();
//                }
//                cur = cur.trieNodes[index];
//            }
//            cur.isWord = true;
//        }
//
//        // add b.b  bac
//        // find bab
//        // true
//        public boolean search(String word) {
//            return search(word, 0, this);
//        }
//
//        // ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
//        // [[],                 ["at"],["and"],     ["an"], ["add"],    ["a"],  [".at"],["bat"],    [".at"],["an."],["a.d."],["b."],    ["a.d"],["."]]
//        private boolean search(String word, int index, TrieNode cur) {
//            for(int i = index; i < word.length(); i++) {
//                char c = word.charAt(i);
//                if (c == '.') {
//                    for(TrieNode node : cur.trieNodes) {
//                        if (node == null) continue;
//                        if (search(word, i + 1, node)) return true;
//                    }
//                    return false;
//                } else {
//                    int cIndex = c - 'a';
//                    if (cur.trieNodes[cIndex] == null) return false;
//                    cur = cur.trieNodes[cIndex];
//                }
//            }
//
//            return cur.isWord;
//        }
//    }

    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    private class Trie {
        Trie[] next;
        boolean isWord;

        public Trie() {
            next = new Trie[26];
            isWord = false;
        }

        public void addWord(String str) {
            Trie cur = this;

            for(char c : str.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Trie();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String str) {
            return search(str, 0, this);
        }

        private boolean search(String str, int index, Trie cur) {
            if (cur == null) return false;
            if (index == str.length()) return cur.isWord;
            for(int i = index; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '.') {
                    for(int j = 0; j < 26; j++) {
                        if (search(str, i + 1, cur.next[j])) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return search(str, i + 1, cur.next[c - 'a']);
                }
            }
            return cur.isWord;
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        wd.search(".a");
    }
}
