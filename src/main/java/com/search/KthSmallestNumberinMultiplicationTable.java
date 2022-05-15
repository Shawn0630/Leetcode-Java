package com.search;

public class KthSmallestNumberinMultiplicationTable {
    // https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/discuss/1580404/Java-Simple-code-oror-Binary-search
    public int findKthNumber(int m, int n, int k) {
        // lo range [1, m*n], mid range [1, m * n - 1]
        int lo=1, hi=m*n;
        while(lo<hi){
            int mid= (lo+hi)/2, cnt=0;
            for (int i=1, j=n; i<=m; i++){
                while(j>=1 && i*j>mid) j--;
                cnt+=j;
            }
            if (cnt>=k) hi=mid;
            else lo=mid+1;
        }
        return lo;
    }
}
