package com.dynamic_programming;

import org.algorithm_visualizer.Array2DTracer;
import org.algorithm_visualizer.Commander;
import org.algorithm_visualizer.Layout;
import org.algorithm_visualizer.Tracer;
import org.algorithm_visualizer.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class DistinctSubsequences {
    private static Array2DTracer dpTracer = new Array2DTracer("dp tracer");
    private static Array2DTracer stTracer = new Array2DTracer("s t tracer");
    private static List<char[]> st;

    public static int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
//  r a b b b i t
//r 1 0 0 0 0 0 0
//a 0 1 0 0 0 0 0
//b 0 0 1 1 1 0 0
//b 0 0 0 1 2 0 0
//i 0 0 0 0 0 3 0
//t 0 0 0 0 0 0 3

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;

//        // visualize {
//            dpTracer.set(dp);
//        // }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
//                // visualize {
//                stTracer.select(0, i - 1);
//                stTracer.select(1, j - 1);
//                Tracer.delay();
//                // }
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    int count = 0;
                    for(int k = 0; k <= i - 1; k++) {
                        count += dp[k][j - 1];
                    }
                    dp[i][j] = count;
                } else {
                    dp[i][j] = 0;
                }
//                // visualize {
//                dpTracer.set(dp);
//                stTracer.deselect(0, i - 1);
//                stTracer.deselect(1, j - 1);
//                Tracer.delay();
//                // }

            }
        }
        int ans = 0;
        for(int i = 1; i <= s.length(); i++) {
            ans += dp[i][t.length()];
        }
        return ans;
    }

    // https://leetcode.com/problems/distinct-subsequences/discuss/1401235/JAVA-or-Easy-Tabulation-Solution
    public static int numDistinct2(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
//  r a b b b i t
//r 1 0 0 0 0 0 0
//a 0 1 0 0 0 0 0
//b 0 0 1 1 1 0 0
//b 0 0 0 1 2 0 0
//i 0 0 0 0 0 3 0
//t 0 0 0 0 0 0 3

        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // visualize {
            dpTracer.set(dp);
        // }
        for(int i = 0; i <= t.length(); i++) {
            for(int j = 0; j <= s.length(); j++) {

                if(i == 0){
                    dp[i][j] = 1;
                } else if(j == 0){
                    dp[i][j] = 0;
                } else if(i > j){
                    dp[i][j] = 0;
                } else {
                    // visualize {
                    stTracer.select(1, i - 1);
                    stTracer.select(0, j - 1);
                    Tracer.delay();
                    // }
                    if (t.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                    // visualize {
                    dpTracer.set(dp);
                    stTracer.deselect(1, i - 1);
                    stTracer.deselect(0, j - 1);
                    Tracer.delay();
                    // }
                }

                // visualize {
                dpTracer.set(dp);
                Tracer.delay();
                // }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        st = new ArrayList<>();
        st.add(s.toCharArray());
        st.add(t.toCharArray());

        stTracer.set(st);
        Layout.setRoot(new VerticalLayout(new Commander[]{stTracer, dpTracer}));
        numDistinct2(s, t);
    }
}
