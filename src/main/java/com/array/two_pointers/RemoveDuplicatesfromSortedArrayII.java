package com.array.two_pointers;

public class RemoveDuplicatesfromSortedArrayII {
    //      1,   1,  1,  2,  2,  3
    //      lr
    //           lr
    //               lr   r
    //      1    1   2   2   2  3
    //              l        r
    //                   l   r


    //      [0,  1,  2,  2,  2,  2,  2,  3,  4,  4,  4]
    //       lr
    //           lr
    //               lr
    //                   lr
    //                   l       r
    //
    public int removeDuplicates(int[] nums) {
        int left = -1, right = 0;

        while (right < nums.length) {
            if (left >= 1 && nums[left] == nums[left - 1]) { // find one duplicates
                    if (nums[left] == nums[right]) { // skip the right
                        right++;
                    } else {
                        nums[++left] = nums[right++];
                    }
                } else {
                    nums[++left] = nums[right++];
                }
            }

        return left + 1;
    }
}
