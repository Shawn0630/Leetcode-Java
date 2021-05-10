package com.search;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /*
    * https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation
    */
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        dp(ans, sb, 0, S);


        return ans;
    }

    private void dp(List<String> ans, StringBuilder cur, int index, String s) {
        if (index == s.length()) {
            ans.add(cur.toString());
            return;
        }

        Character c = s.charAt(index);
        if (c >= '0' && c <= '9') {
            cur.append(c);
            dp(ans, cur, index + 1, s);
            cur.setLength(cur.length() - 1);
        } else {
            cur.append(c);
            dp(ans, cur, index + 1, s);
            cur.setLength(cur.length() - 1);
            if (Character.isLowerCase(c)) {
                cur.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                cur.append(Character.toLowerCase(c));
            }
            dp(ans, cur, index + 1, s);
            cur.setLength(cur.length() - 1);
        }
    }
}
