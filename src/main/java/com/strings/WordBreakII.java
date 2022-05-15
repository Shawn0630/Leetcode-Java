package com.strings;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        List<String> list = new ArrayList<>();

        for(String word : wordDict) {
            root.addString(word);
        }

        //return wordBreakHelper(s,wordDict,"",list);
        wordBreakHelper2(s, root, "", s.length() - 1, list);

        return list;
    }

    public List<String> wordBreakHelper(String s, List<String> wordDict,String ans,List<String> list){

        //Base Case
        if(s.length()==0){
            ans=ans.trim();
            list.add(ans);
            return list;
        }

        for(int i=0;i<s.length();i++){
            String left=s.substring(0,i+1);

            if(wordDict.contains(left)==true){
                String storedAns=ans;
                ans=ans+left+" ";
                wordBreakHelper(s.substring(i+1),wordDict,ans,list);
                //backtracking
                ans=storedAns;
            }
        }
        return list;
    }

    public void wordBreakHelper2(String s, Trie root, String ans, int end, List<String> list) {
        String cached = ans;
        if (root.containString(s.substring(0, end + 1))) {
            ans = s.substring(0, end + 1) + " " + ans;
            list.add(ans.trim());
        }
        // "pineapplepenapple"
        //["apple","pen","applepen","pine","pineapple"] NO ELSE
        ans = cached;
        for(int i = 0; i < end; i++) {
            String left = s.substring(i + 1, end + 1);
            if (root.containString(left)) {
                ans = left + " " + ans;
                wordBreakHelper2(s, root, ans, i, list);
                ans = cached;
            }
        }
    }


    //  s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    // backtracking
    public List<String> wordBreak3(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        wordBreak3DFS(0, "", s, wordDict, ans);

        return ans;
    }

    private void wordBreak3DFS(int cur, String curString, String s, List<String> wordDict, List<String> ans) {

        // edge
        if (cur == s.length()) {
            ans.add(curString);
            return;
        }

        for(int i = cur; i < s.length(); i++) {
            String word = s.substring(cur, i + 1);
            if (wordDict.contains(word)) {
                String cache = curString;
                curString = curString.equals("") ? word : curString + " " + word;
                wordBreak3DFS(i + 1, curString, s, wordDict, ans);
                curString = cache;
            }
        }

    }

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
}
