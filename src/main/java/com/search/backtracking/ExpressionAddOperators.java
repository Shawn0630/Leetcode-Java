package com.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    List<String> ans;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();

        addOperatorsDFS(num, 0, "", 0, 0, target);

        return ans;
    }

    private void addOperatorsDFS(String num, int curIndex, String curString, int prev, int curSum, int target) {
        if (curIndex == num.length()) {
            if (curSum + prev == target) {
                ans.add(curString);
            }
        }

        int cur = 0;
        for(int i = curIndex; i < num.length(); i++) {
            cur = cur * 10 + num.charAt(i) - '0';

            if (curIndex == 0) {// avoid adding operator at the begining
                addOperatorsDFS(num, i + 1, String.valueOf(cur), cur, curSum, target);
                continue;
            }

            addOperatorsDFS(num, i + 1, curString + '+' + cur, +cur, curSum + prev, target);
            addOperatorsDFS(num, i + 1, curString + '-' + cur, -cur, curSum + prev, target);
            addOperatorsDFS(num, i + 1, curString + "*" + cur, prev * cur, curSum, target);
        }

    }


    // 123 target = 6
    // 1        2       3
    public List<String> addOperators2(String num, int target) {
        List<String> ans = new ArrayList<>();
        addOperatorDFS(num, "", 0, 0, 0, target, ans);

        return ans;
    }

    private void addOperatorDFS(String num, String s, int index, int sum, int prev, int target, List<String> ans) {
        if (index == num.length()) {
            if (sum + prev == target) {
                ans.add(s);
            }
            return;
        }

        int cur = 0;
        for(int i = index; i < num.length(); i++) {
           char c = num.charAt(i);
           cur = cur * 10 + c - '0';

           if (index == 0) {
               addOperatorDFS(num, String.valueOf(cur), i + 1, 0, cur, target, ans);
               continue;
           }

            // sum + prev + cur
            addOperatorDFS(num, s + "+" + cur, i + 1, sum + prev, cur, target, ans);
            addOperatorDFS(num, s + "-" + cur, i + 1, sum + prev, -cur, target, ans);
            // sum + prev * cur
            addOperatorDFS(num, s + "*" + cur, i + 1, sum, prev * cur, target, ans);
        }
    }
}
