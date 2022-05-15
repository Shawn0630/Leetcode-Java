package com.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumNumberofSwapstoMaketheStringBalanced {
    // ]  [  ] [
    // -1 0  1 0
    // [ [ ] [ ] ]
    // 1 2 1 2 1 0
    // https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1390319/How-to-reach-the-optimal-solution-or-Explained-with-Intuition-and-Diagram
    // min step => no need to swap [] and only need to swap ][
    public int minSwaps(String s) {
        int minStep = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.offer(s);
        set.add(s);

        // []][][
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> list = new ArrayList<>();
            while (size > 0) {
                list.add(queue.poll());
                size--;
            }

            for(String cur : list) {
                int i = firstInvalid(cur);
                if(i == -1) return minStep;
                else {
                    for(int j = i + 1; j < cur.length(); j++) {
                        if (cur.charAt(j) == '[') {
                            String next = swap(cur, i, j);
                            if (!set.contains(next)) {
                                queue.offer(next);
                                set.add(next);
                            }
                        }
                    }
                }
            }

            minStep++;
        }

        return -1;
    }


    // abc, 0, 2 => cba
    private String swap(String s, int i, int j) {
        if (i < 0 || i > s.length() ||
            j < 0 || j > s.length()) {
            return s;
        }

        char[] carray = s.toCharArray();
        char temp = carray[i];
        carray[i] = carray[j];
        carray[j] = temp;

        return new String(carray);
    }

    private int firstInvalid(String s) {
        int stack = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack++;
            } else if (s.charAt(i) == ']') {
                if (stack > 0) stack--;
                else return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        MinimumNumberofSwapstoMaketheStringBalanced minimumNumberofSwapstoMaketheStringBalanced = new MinimumNumberofSwapstoMaketheStringBalanced();
        minimumNumberofSwapstoMaketheStringBalanced.minSwaps("]]][[[");
    }
}
