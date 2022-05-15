package com.array;

public class StreamChecker {
    // https://leetcode.com/problems/stream-of-characters/discuss/278769/Java-Trie-Solution

    TireNode root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        root = createTire(words);
        sb = new StringBuilder();
    }

    public boolean query(char letter) {
        sb.append(letter);
        TireNode cur = root;
        int idx = sb.length() - 1;

        while (cur != null && idx >= 0) {
            if (cur.isWord) {
                return true;
            }

            cur = cur.next[sb.charAt(idx--) - 'a'];
        }

        return cur != null && cur.isWord;
    }

    private TireNode createTire(String[] words) {
        TireNode root = new TireNode();

        for(String word: words) {
            char[] chars = word.toCharArray();
            TireNode cur = root;
            for(int i = word.length() - 1; i >= 0; i--) {
                if (cur.next[chars[i] - 'a'] == null) {
                    cur.next[chars[i] - 'a'] = new TireNode();
                }
                cur = cur.next[chars[i] - 'a'];
            }
            cur.isWord = true;
        }

        return root;
    }

    private class TireNode {
        boolean isWord;
        TireNode[] next;

        TireNode() {
            isWord = false;
            next = new TireNode[26];
        }
    }
}
