package com.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();

        partitionHelper(s, new ArrayList<>(), 0);
        return ans;
    }

    private void partitionHelper(String s, List<String> res, int cur) {
        if (cur == s.length()) { // base case
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = cur; i < s.length(); i++) {
            String subString = s.substring(cur, i + 1);
            if (isPalindrome(subString)) {
                res.add(subString);
                partitionHelper(s, res, i + 1);
                res.remove(res.size() - 1);
            }
        }
    }


    // a    b   a => true
    // left     right
    //      left/right   => true
    // aab => false;
    // a    b   b   a    => true;
    // left         right
    //      l    r          => true
    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false; // by definition
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left ++;
                right --;
            }
        }

        return true;
    }
}
