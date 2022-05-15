package com.search;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    // https://leetcode.com/problems/expression-add-operators/discuss/1449082/Simple-and-Clean-Java-Solution
    // https://leetcode.com/problems/expression-add-operators/discuss/71921/Java-simple-solution-beats-96.56
    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return ans;
        }

        dfs("", 0, num, 0, target, 0, ans);
        return ans;
    }

    private static void dfs(String cur, int index, String num, int result, int target, int previous, List<String> ans) {
        if (index == num.length()) {
            if (result + previous == target) {
                ans.add(cur);
            }
            return;
        }

        int currentValue = 0;
        int i;
        for(i = index; i < num.length(); i++) {
            char c = num.charAt(i);
            currentValue = currentValue * 10 + c - '0';
            if (index == 0) {
                dfs(String.valueOf(currentValue), i + 1, num, result, target, currentValue, ans);
                continue; // 00 -> continue, no break
            }

            dfs(cur + '+' + currentValue, i + 1, num, result + previous, target, currentValue, ans);
            dfs(cur + '-' + currentValue, i + 1, num, result + previous, target, -currentValue, ans);
            dfs(cur + "*" + currentValue, i + 1, num, result, target, previous * currentValue, ans);
            if (num.charAt(index) == '0') break;
        }

    }


    public static void main(String[] main) {
        String num = "00";
        int target = 0;
        List<String> result = addOperators(num, target);
        System.out.println(result);
    }
}
