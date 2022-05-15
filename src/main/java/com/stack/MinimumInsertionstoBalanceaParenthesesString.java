package com.stack;

public class MinimumInsertionstoBalanceaParenthesesString {
    // one open requires two close
    // https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/discuss/780199/JavaC%2B%2BPython-Straight-Forward-One-Pass
    // https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/discuss/780199/JavaC%2B%2BPython-Straight-Forward-One-Pass
    // two consectuctive: two cases, match, miss 1 )
    //          ( (  )  )  )
    // close    2 4  3  2 1
    // open     0 0  0  0 0

    //          (  )  )
    // close    2  1  0
    // open     0  0  0

    //          ) )   (  )   )  (
    // close    1  0  2  1   0  2
    // open     1  1  1  1   1  1    = 3

    //                        )               )      )         (
    //          (  (  )  )  )   (  (  )  )  )   (  )   (  )  )   )  )
    // stack    1  2  3
    // close    2  4  3  2  1   3  5  4  3  2   4  3   5  4  3   2  1
    // open     0  0  0  0  0   0  0  0  0  0   0  0   0  0  0   0  0


    //            )  ) ) )
    // close      -1
    //                   ) )
    //           (  )  (     )  )
    // close     2  1
    // open      0  0

    //             int close_needed = 0; // incrmented by 2 for every open bracket
    //            int open_missing = 0; // incremented by 1 for every open bracket missing
    //            int close_missing = 0; // incremented by 1 for every close bracket missing
    public int minInsertions(String s) {
        int requireClose = 0;
        int requireOpen = 0;
        int missClose = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (requireClose % 2 > 0) { //requires 1
                    requireClose--;
                    missClose++;
                }
                requireClose += 2;
            } else if (s.charAt(i) == ')') {
                requireClose--;
                if (requireClose < 0) {
                    requireClose = 1;
                    requireOpen++;
                }
            }
        }

        return requireOpen + requireClose + missClose;
    }
}
