package com.array.parentheses;

public class MinimumNumberofSwapstoMaketheStringBalanced {
    // https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1390319/How-to-reach-the-optimal-solution-or-Explained-with-Intuition-and-Diagram
    // Alternative Solution: BFS
    public int minSwaps(String s) {
        int open = 0;

        for(char c : s.toCharArray()) {
            if (c == '[') {
                open++;
            } else {
                if (open > 0) open--;
            }
        }

        return (open + 1) / 2;
    }
}
