package com.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
    private List<String> ans;
    // https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
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


    public List<String> removeInvalidParentheses2(String s) {
        List<String> ans = new ArrayList<>();
        removeInvalidParenthesesDFS(ans, s, 0, 0, '(', ')');
        return ans;
    }

    // two pointer, curIndex [0...curIndex - 1] satisfy constraint, curIndexJ try removing depulicated parenthesse
    // https://leetcode.com/problems/remove-invalid-parentheses/discuss/75038/Evolve-from-intuitive-solution-to-optimal-a-review-of-all-solutions
    private void removeInvalidParenthesesDFS(List<String> ans, String currStr, int curIndex, int curIndexJ, char open, char close) {

        int stack = 0;
        for(int i = curIndex; i < currStr.length(); i++) {
            if (currStr.charAt(i) == open) stack++;
            else if (currStr.charAt(i) == close) stack--;
            if (stack >= 0) continue;
            for(int j = curIndexJ; j <= i; j++) {
                if (currStr.charAt(j) == close && (j == curIndexJ || currStr.charAt(j - 1) != close)) {
                    removeInvalidParenthesesDFS(ans, currStr.substring(0, j) + currStr.substring(j + 1, currStr.length()), i, j, open, close);
                }
            }
            return;
        }
        String reversed = new StringBuilder(currStr).reverse().toString();
        if (open == '(') {
            removeInvalidParenthesesDFS(ans, reversed, 0, 0, close, open);
        } else {
            ans.add(reversed);
        }
    }


    public List<String> removeInvalidParentheses3(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.offer(s);
        set.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValidString(cur)) {
                ans.add(cur);
            } else if (ans.isEmpty()) { // the shortest path
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                        String next = cur.substring(0, i) + cur.substring(i + 1, cur.length());
                        if (!set.contains(next)) {
                            set.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean isValidString(String s) {
        int stack = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') stack++;
            else if (c == ')') {
                if (stack > 0) {
                    stack--;
                } else {
                    return false;
                }
            }
        }

        return stack == 0;
    }
}
