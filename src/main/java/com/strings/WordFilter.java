package com.strings;

import java.util.HashSet;
import java.util.Set;

public class WordFilter {
    public WordFilter(String[] words) {

    }

    public int f(String prefix, String suffix) {
        return -1;
    }


    private class TrieNode {
        TrieNode next[];
        Set<Integer> indexes;

        public TrieNode() {
            next = new TrieNode[26];
            indexes = new HashSet<>();
        }

        public void addString(String word, int index) {
            
        }
    }
}
