package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    private int n;
    private int k;
    private List<List<Integer>> ans;
    private boolean[] used;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        ans = new ArrayList<>();

        if (n < 0 || k < 0 || k > n) {
            return ans;
        }

        dfs(0, 0, used);
        return ans;
    }

    private void dfs(int cur_n, int cur_k, boolean[] used) {
       if (cur_k == k) {
           List<Integer> array = new ArrayList<>();
           for(int i = 1; i < used.length; i++) {
               if (used[i]) array.add(i);
           }
           ans.add(array);
           return;
       }

       for(int i = cur_n + 1; i <= n; i++) {
           used[i] = true;
           dfs(i, cur_k + 1, used);
           used[i] = false;
       }

    }
}
