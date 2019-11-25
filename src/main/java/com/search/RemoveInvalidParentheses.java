package com.search;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    private List<String> ans;

    public List<String> removeInvalidParentheses(String s) {
        ans = new ArrayList<>();

        if (s == null) {
            return ans;
        }


        int[] count = parenthesisCount(s);
        dfs(s, 0, count[0], count[1]);

        return ans;
    }

    private void dfs(String s, int start, int left, int right) {
        if(left == 0 && right == 0 && isValid(s)) {
            ans.add(s);
        }

        for(int i = start; i < s.length(); i++) {
            if (right > 0) {
                if (s.charAt(i) == ')' && (i == 0 || s.charAt(i - 1) != ')')) {
                    String ns = s.substring(0, i) + s.substring(i + 1);
                    dfs(ns, i, left, right - 1);
                }
            } else if (left > 0) {
                if (s.charAt(i) == '(' && (i == 0 || s.charAt(i - 1) != '(')) {
                    String ns = s.substring(0, i) + s.substring(i + 1);
                    dfs(ns, i, left - 1, right);
                }
            }
        }
    }

    private boolean isValid(String s) {
        if(s == null) {
            return false;
        }

        int left = 0;
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                left++;
            } else if (cs[i] == ')') {
                if (left > 0) left--;
                else return false;
            }
        }

        return true;
    }

    private int[] parenthesisCount(String s) {
        if (s == null) {
            return new int[]{0, 0};
        }

        int left = 0;
        int right = 0;
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                left++;
            } else if (cs[i] == ')') {
                if (left > 0) left--;
                else right++;
            }
        }

        return new int[]{left, right};
    }
}
