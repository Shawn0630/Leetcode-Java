package com.array.parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
    // intuition:
    // 1. min operations means don't remove valid pairs.
    // 2. min operations means BFS
    // (    )   (   )   )   (   )
    //      -           -
    // ()()()  (())()
    public List<String> removeInvalidParentheses(String s) {
        Set<String> visited = new HashSet<>();
        List<String> ans = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        visited.add(s);
        queue.offer(s);

        while (!queue.isEmpty() && ans.isEmpty()) {
            List<String> curSteps = new ArrayList<>();
            int size = queue.size();

            while (size > 0) {
                curSteps.add(queue.poll());
                size--;
            }

            for(String cur : curSteps) {

                if (isValid(cur)) {
                    ans.add(cur);
                }

                for(int i = 0; i < cur.length(); i++) { // remove ith char
                    String next = cur.substring(0, i) + cur.substring(i + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        return ans;
    }

    public List<String> removeInvalidParentheses2(String s) {
        List<String> ans = new ArrayList<>();

        int[] extras = extrasParentheses(s);
        int extraLeft = extras[0];
        int extraRight = extras[1];

        removeInvalidParenthesesDFS(new StringBuilder(), s, 0, extraLeft + extraRight, ans);

        return ans;
    }

    private void removeInvalidParenthesesDFS(StringBuilder sb, String s, int cur, int minOps, List<String> ans) {
        if (cur == s.length()) {
            if (isValid(sb.toString())) {
                ans.add(sb.toString());
            }
        }  else {
            char c = s.charAt(cur);

            sb.append(c);
            removeInvalidParenthesesDFS(sb, s, cur + 1, minOps, ans); // take
            sb.deleteCharAt(sb.length() - 1);
            if ((c == '(' || c == ')') && minOps > 0 && !(sb.length() > 0 && s.charAt(cur) == sb.charAt(sb.length() - 1))) {
                removeInvalidParenthesesDFS(sb, s, cur + 1, minOps - 1, ans); // skip
            }
        }
    }

    private int[] extrasParentheses(String s) {
        int extraLeft = 0;
        int extraRight = 0;

        for(char c : s.toCharArray()) {
            if (c == '(') {
                extraLeft++;
            } else if (c == ')') {
                if (extraLeft > 0) extraLeft--;
                else {
                    extraRight++;
                }
            }
        }

        return new int[]{extraLeft, extraRight};
    }

    private boolean isValid(String s) {
        int count = 0; // ( => +1 ) => -1

        for(char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count - 1 < 0) {
                    return false;
                } else {
                    count--;
                }
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        removeInvalidParentheses.removeInvalidParentheses("()())()");
    }
}
