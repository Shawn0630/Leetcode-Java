package com.bitoperation;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int result = 0;
        int negativeCount = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
                nums[i] = -nums[i];
            }
        }

        for(int i = 0; i < 32; i++) {
            int count = 0;
            int num = 1 << i;
            for(int j = 0; j < nums.length; j++) {
                if ((nums[j] & num) == num) {
                    count = (count + 1) % 3;
                }
            }
            if (count == 1) {
                result += 1 << i;
            }
        }

        return (negativeCount % 3 == 1 ? -result : result);
    }

    public int singleNumber2(int[] nums) {
        int negativeCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
                nums[i] = -nums[i];
            }
        }

        int mask = 1;
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int num : nums) {
                if ((num & mask) == mask) { // num & mask == 0
                    count++;
                }
            }
            if (count % 3 == 1) {
                ans = ans | mask;
            }
            mask = mask << 1;
        }

        return (negativeCount % 3 == 1 ? -ans : ans);
    }

}
