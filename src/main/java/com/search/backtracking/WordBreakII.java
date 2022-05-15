package com.search.backtracking;

import com.strings.WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordBreakDFS("", s, 0, wordDict);


        return res;
    }

    // [a      ab]
    //  0       1       2
    //   a       a       b
    //  |
    //        |
    //              |
    private void wordBreakDFS(String cur, String s, int index, List<String> wordDict) {
        if (index >= s.length()) {
            return;
        }

        if (wordDict.contains(s.substring(index))) {
            res.add(index == 0 ? s.substring(index) : cur + " " + s.substring(index));
        }

        for(int i = index; i < s.length(); i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                wordBreakDFS(index == 0 ? s.substring(index, i + 1) : cur + " " + s.substring(index, i + 1), s, i + 1, wordDict);
            }
        }
    }


    public static void main(String[] args) {
        WordBreakII wb = new WordBreakII();
        wb.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
    }
}
