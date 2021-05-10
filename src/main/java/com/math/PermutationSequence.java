package com.math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    List<Integer> list;
    StringBuilder sb;
    public String getPermutation(int n, int k) {// n number, kth sequence

        this.list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }


        this.sb = new StringBuilder();
        recursive(n - 1, k - 1);

        return sb.toString();
    }

    private void recursive(int n, int k) {
        if (n == 0) {
            sb.append(list.get(0));
            return;
        } else {
            int factorial = fact(n);
            int cur = (k / factorial) % (list.size());
            sb.append(list.get(cur));
            list.remove(cur);
            recursive(n - 1, k % factorial);
        }
    }

    private int fact(int n) {
        int ans = 1;
        while (n >= 1) {
            ans *= n;
            n--;
        }

        return ans;
    }
}
