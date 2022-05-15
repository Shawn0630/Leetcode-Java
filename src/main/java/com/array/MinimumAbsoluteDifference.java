package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbs = arr[1] - arr[0];
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(arr[0], arr[1]));

        // 1    3     5

        for(int i = 1; i < arr.length - 1; i++) {
             int right = arr[i + 1];
             int rightDiff = Math.abs(arr[i] - right);
             if (rightDiff < minAbs) {
                 minAbs = rightDiff;
                 ans = new ArrayList<>();
                 ans.add(Arrays.asList(arr[i], right));
             } else if (rightDiff == minAbs) {
                 ans.add(Arrays.asList(arr[i], right));
             }
        }

        return ans;
    }
}
