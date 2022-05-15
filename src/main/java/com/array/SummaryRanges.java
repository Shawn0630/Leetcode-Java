package com.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        List<String> ans = new ArrayList<>();
        while (i < nums.length) {
            int j = i;
            while (j < nums.length - 1 && nums[j + 1] - nums[j] == 1) {
                j++;
            }

            if (i == j) {
                ans.add(String.valueOf(nums[i]));
            } else {
                ans.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }

        return ans;
    }
}
