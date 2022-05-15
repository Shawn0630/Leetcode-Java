package com.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    // string pass by value
    // https://leetcode.com/problems/find-unique-binary-string/discuss/1418735/Java-DFS-solution
    private static Set<String> set;
    private static String dfs(int n, String str) {
        if (n == 0 && !set.contains(str)) {
            return str;
        }
        String res;

        res = dfs(n - 1, str + "0");
        if (res != null) return res;
        res = dfs(n - 1, str + "1");
        return res;
    }
    public static String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>();
        set.addAll(Arrays.asList(nums));
        return dfs(nums.length, "");
    }

    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"111","011","001"}));
    }
}
