package com.strings.trie;

import java.util.HashMap;
import java.util.Map;

public class ShortEncodingofWords {
    // https://leetcode.com/problems/short-encoding-of-words/discuss/2172351/Python-or-Sum-of-root-to-leaf-paths-on-Trie-with-Diagram
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();// as #

        for(String word : words) {
            TrieNode ptn = root;
            for(int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                ptn.children.putIfAbsent(c, new TrieNode());
                ptn = ptn.children.get(c);
            }
        }

        return sumOfLeafPath(root, 1);
    }

    private class TrieNode {
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    private int sumOfLeafPath(TrieNode root, int height) {
        if (root.children.size() == 0) {
            return height;
        }
        int sum = 0;
        for(TrieNode child : root.children.values()) {
            sum += sumOfLeafPath(child, height + 1);
        }

        return sum;
    }
}
