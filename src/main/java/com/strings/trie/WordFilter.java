package com.strings.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordFilter {
    // https://leetcode.com/problems/prefix-and-suffix-search/discuss/2164117/Visual-Explanation-or-Double-Trie-JAVA

    TrieNode prefixRoot;
    TrieNode suffixRoot;
    Map<String, Integer> strToIndex;
    public WordFilter(String[] words) {
        prefixRoot = new TrieNode();
        suffixRoot = new TrieNode();
        strToIndex = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            insertWord(word);
            strToIndex.put(word, i);
        }
    }

    private void insertWord(String word) {
        TrieNode prefixPtn = prefixRoot;
        TrieNode suffixPtn = suffixRoot;

        for(int i = 0; i < word.length(); i++) {
            char pc = word.charAt(i);
            prefixPtn.children.putIfAbsent(pc, new TrieNode());
            prefixPtn = prefixPtn.children.get(pc);
            prefixPtn.words.add(word);

            char sc = word.charAt(word.length() - 1 - i);
            suffixPtn.children.putIfAbsent(sc, new TrieNode());
            suffixPtn = suffixPtn.children.get(sc);
            suffixPtn.words.add(word);
        }


    }

    public int f(String prefix, String suffix) {
        Set<String> prefixs = find(prefix, prefixRoot);
        Set<String> suffixs = find(new StringBuilder(suffix).reverse().toString(), suffixRoot);

        int index = -1;
        for(String str : prefixs) {
            if (suffixs.contains(str)) {
                index = Math.max(index, strToIndex.get(str));
            }
        }

        return index;
    }

    private Set<String> find(String str, TrieNode root) {
        TrieNode ptn = root;
        for(int i = 0; i < str.length(); i++) {
            char pc = str.charAt(i);
            if (ptn.children.get(pc) == null) return new HashSet<>();
            ptn = ptn.children.get(pc);
        }

        return ptn.words;
    }


    private class TrieNode {
        public Map<Character, TrieNode> children;
        public Set<String> words;
        public TrieNode() {
            children = new HashMap<>();
            words = new HashSet<>();
        }
    }
}
