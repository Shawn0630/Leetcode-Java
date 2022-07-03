package com.strings;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        dp = new Boolean[s.length()];

        for(String word : wordDict) {
            root.addString(word);
        }

        return wordBreak2(0, s, root);
    }

    private boolean wordBreak(int end, String s, Trie root) {
        if(dp[end] != null) {
            return dp[end];
        }
        for(int i = 0; i < end; i++) {
            if (wordBreak(i, s, root) && root.containString(s.substring(i + 1, end + 1))) {
                dp[end] = true;
                return true;
            }
        }

        dp[end] = root.containString(s.substring(0, end + 1));
        return dp[end];
    }

    private boolean wordBreak2(int start, String s, Trie root) {
        if (start == s.length()) {
            return true;
        }
        if(dp[start] != null) {
            return dp[start];
        }
        for(int i = start; i < s.length(); i++) {
            if (root.containString(s.substring(start, i + 1))) {
                if (wordBreak2(i + 1, s, root)) {
                    dp[start] = true;
                    return true;
                }
            }
        }

        dp[start] = false;
        return dp[start];
    }
    // 0     1   2   3
    //"a  |  b | c   d"  ["a","abc","b","cd"]
    // wordBreak(3) => word(0)&&s[1, 4) [false] || word(1)&&s[2, 4) [true] || word(2)&&s[3,4)
    // word(0) => s[0, 1) [true]
    // word(1) => word(0) && s[1, 2) [true]

    private class Trie {
        Trie[] next;
        boolean isWord;

        public Trie() {
            next = new Trie[26];
            isWord = false;
        }

        public void addString(String s) {
            Trie cur = this;
            for(char c : s.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Trie();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean containString(String s) {
            Trie cur = this;
            for(char c : s.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }

            return cur.isWord;
        }
    }
    public static void main(String[] arg) {
        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreak("abcd", Arrays.asList("a","abc","b","cd"));
    }
}
