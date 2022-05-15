package com.strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    char[][] map = new char[][]{
            {},
            {},
            {'a', 'b', 'c'}, //2
            {'d', 'e', 'f'}, //3
            {'g', 'h', 'i'}, //4
            {'j', 'l', 'k'}, //5
            {'m', 'n', 'o'}, //6
            {'p', 'q', 'r', 's'}, //7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'}, //9
    };
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        letterCombinationsDFS(digits, 0, ans, "");


        return ans;
    }

    private void letterCombinationsDFS(String digits, int cur, List<String> ans, String curString) {
        if (cur == digits.length()) {
            ans.add(curString);
            return;
        }

        int dig = digits.charAt(cur) - '0';
        for(char c : map[dig]) {
            letterCombinationsDFS(digits, cur + 1, ans, curString + c);
        }

    }
}
