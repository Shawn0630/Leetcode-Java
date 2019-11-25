package com.bitoperation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null) return -1;
        int negativeCount = 0;
        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount = (negativeCount + 1) % 2;
                nums[i] = -nums[i];
            }
        }

        for(int i = 0; i < 32; i++) {
            int num = 1 << i;
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & num) == num) {
                    count = (count + 1) % 2;
                }
            }
            if (count == 1) {
                result += 1 << i;
            }
        }

        return negativeCount == 1 ? -result : result;
    }
}
