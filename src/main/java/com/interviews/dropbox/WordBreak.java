package com.interviews.dropbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        wordBreakDFS(s, "", wordDict);

        return ans;
    }

    Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s == null || s.length() == 0) {
            return true;
        }
        for(int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (wordDict.contains(str) && wordBreak2(s.substring(i), wordDict)) return true;
        }

        map.put(s, false);
        return false;
    }

    private void wordBreakDFS(String s, String cur, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            ans.add(cur);
            return;
        }


        for(int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word)) {
                wordBreakDFS(s.substring(i), cur.isEmpty() ? word : cur + " " + word, wordDict);
            }
        }
    }

    public static void main(String agrs[]) {
        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreak2("leetcode", Arrays.asList("leet", "code"));
    }
}
