package com.strings.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchSuggestionsSystem {
    // https://leetcode.com/problems/search-suggestions-system/discuss/2167835/A-More-Intuitive-Solution-or-JAVA-Explained
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for(String product : products) {
            TrieNode ptn = root;
            for(int i = 0; i < product.length(); i++) {
                char c = product.charAt(i);
                ptn.children.putIfAbsent(c, new TrieNode());
                ptn = ptn.children.get(c);
                ptn.products.offer(product);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(char c : searchWord.toCharArray()) {
            List<String> recom = new ArrayList<>();
            if (!root.children.containsKey(c)) break;
            root = root.children.get(c);
            int idx = 0;
            while (!root.products.isEmpty() && idx < 3) {
                recom.add(root.products.poll());
                idx++;
            }
            for(String s : recom) {
                root.products.offer(s);
            }
            ans.add(recom);
        }


        while (ans.size() < searchWord.length()) {
            ans.add(new ArrayList<>());
        }

        return ans;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        PriorityQueue<String> products;

        public TrieNode() {
            children = new HashMap<>();
            products = new PriorityQueue<>(String::compareTo);
        }
    }
}
