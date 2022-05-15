package com.bitoperation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null) {
            return null;
        }

        int xor = 0;

        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int bit = xor & ~(xor - 1);
        int one = 0, two = 0;

        for(int i = 0; i < nums.length; i++) {
            if ((bit & nums[i]) == 0) {
                one ^= nums[i];
            } else {
                two ^= nums[i];
            }
        }

        return new int[]{one, two};
    }

    private int[] singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int xor = 0;
        for(int num : nums) {
            xor = xor ^ num;
        }

        int mask = 1;
        // find the first ones from right to left
        while ((xor & mask) == 0) {
            mask = mask << 1;
        }

        int one = 0, two = 0;
        for(int num : nums) {
            if ((mask & num) == 0) {
                one ^= num;
            } else {
                two ^= num;
            }
        }

        return new int[]{one, two};
    }
}
