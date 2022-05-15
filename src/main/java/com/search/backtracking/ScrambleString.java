package com.search.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScrambleString {
    // s1 = "great", s2 = "rgeat"
    //  0   1   2   3   4
    //  g   r   e   a   t
    //        |
    //    |

    // [0 1]
    // [2,4]


    // "abc"
    // "cba"
    Set<String> visited = new HashSet<>();
    // https://leetcode.com/problems/scramble-string/discuss/1227919/well-commented-codeor-dp-or-memoization-or-MCM
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() == 1) {
            return false;
        }
        if (visited.contains(s1)) return false;
        for(int i = 0; i < s1.length(); i++) {
            String s1left = s1.substring(0, i + 1);
            String s1right = s1.substring(i + 1);

            String s2left = s2.substring(0, i + 1);
            String s2right = s2.substring(i + 1);


            System.out.println(s1left + " " + s2left + " && " + s1right + " " + s2right);
            boolean nonSwap = isScramble(s1left, s2left) && isScramble(s1right, s2right);

            if (nonSwap) return true;
            visited.add(s1left + s1right);

            s2left = s2.substring(s2.length() - i - 1);
            s2right = s2.substring(0, i + 1);

            System.out.println(s1left + " " + s2left + " && " + s1right + " " + s2right);
            boolean swap = isScramble(s1left, s2left) && isScramble(s1right, s2right);

            if (swap) return true;

            visited.add(s1right + s1left);
            visited.add(s1left + s1right);
        }

        return false;
    }

    public static void main(String[] args) {
        ScrambleString sc = new ScrambleString();
        sc.isScramble("great", "rgeat");
    }
}
