package com.interviews.dropbox.oa;

import java.util.Arrays;

public class SatisfyingInteger {
    public int[] getArray(int[] inputs) {
        int[] ans = new int[inputs.length];
        int idx = 0;

        for(int i = 0; i < inputs.length; i++) {
           if (i == 0) {
               ans[idx++] = inputs[i];
               continue;
           }
           if (i == 1 && inputs[i - 1] < inputs[i]) {
               ans[idx++] = inputs[i];
               continue;
           }
           if (i >= 2) {
               if (inputs[i - 1] < inputs[i] &&
                   inputs[i - 2] < inputs[i]) {
                   ans[idx++] = inputs[i];
               }
           }
        }

        return Arrays.copyOf(ans, idx);
    }

    public static void main(String[] args) {
        SatisfyingInteger satisfyingInteger = new SatisfyingInteger();
        int[] inputs = new int[]{1, 2, 4};
        int[] outputs = satisfyingInteger.getArray(inputs);

        for(int num : outputs) {
            System.out.println(num + " ");
        }
    }
}
