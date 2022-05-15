package com.array;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {

    // 0    1   2   3
    //
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length / 2; i++) {
            int count = nums[i * 2];
            int element = nums[i * 2 + 1];

            while (count > 0) {
                ans.add(element);
                count--;
            }
        }

        int[] result = new int[ans.size()];

        for(int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }


        return result;

    }
}
