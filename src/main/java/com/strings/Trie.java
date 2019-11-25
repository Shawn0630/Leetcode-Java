package com.strings;

public class Trie {

    private class Node {
        boolean isWord;
        Node[] next;

        public Node() {
            isWord = false;
            next = new Node[26];
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] cs = word.toCharArray();
        Node cur = root;

        for(char c : cs) {
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }

        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        char[] cs = word.toCharArray();

        Node cur = root;
        for(char c : cs) {
            if (cur.next[c - 'a'] == null) {
                return false;
            } else {
                cur = cur.next[c - 'a'];
            }
        }

        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        char[] cs = prefix.toCharArray();

        Node cur = root;
        for(char c : cs) {
            if (cur.next[c - 'a'] == null) {
                return false;
            } else {
                cur = cur.next[c - 'a'];
            }
        }

        return true;
    }
}
