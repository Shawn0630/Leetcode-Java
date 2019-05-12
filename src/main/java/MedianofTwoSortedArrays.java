public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0;
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (nums1.length == 0) {
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / (double)2 : nums2[nums2.length / 2];
        }

        int nums1_start = 0;
        int nums1_end = nums1.length - 1;
        int nums1_length = nums1.length;
        int nums2_length = nums2.length;

        // treat single element as the same
        while(nums1_start <= nums1_end) {
            int nums1_index = nums1_start + (nums1_end - nums1_start) / 2;
            int nums2_index = indexOfDivider(nums1_length, nums2_length, nums1_index);
            int L1 = nums1[nums1_index];
            int R1 = nums1_index >= nums1.length - 1 ? Integer.MAX_VALUE : nums1[nums1_index + 1];
            int L2 = nums2_index < 0 ? Integer.MIN_VALUE : nums2[nums2_index];
            int R2 = nums2_index >= nums2.length - 1 ? Integer.MAX_VALUE : nums2[nums2_index + 1];
            if (R1 < L2) {
                nums1_start = nums1_index + 1;
            } else if (L1 > R2) {
                nums1_end = nums1_index - 1;
            } else {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (double)((Math.max(L1, L2) + Math.min(R1, R2))) / (double)2;
                } else {
                    return Math.max(L1, L2);
                }
            }
        }
        if (nums1_end == -1) {
            int L1 = Integer.MIN_VALUE;
            int R1 = nums1[0];
            int nums2_index = indexOfDivider(nums1_length, nums2_length, -1);
            int L2 = nums2_index < 0 ? Integer.MIN_VALUE : nums2[nums2_index];
            int R2 = nums2_index >= nums2.length - 1 ? Integer.MAX_VALUE : nums2[nums2_index + 1];
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (double) ((Math.max(L1, L2) + Math.min(R1, R2))) / (double) 2;
                } else {
                    return Math.max(L1, L2);
                }
        }

        return findMedianSortedArrays(nums2, nums1);

//        nums1_start = nums1[0] > nums2[nums2.length - 1] ? -1 : 0;
//        nums1_mid = nums1_start;
//        int nums2_index = indexOfDivider(nums1_length, nums2_length, nums1_start);
//        int L1 = nums1_mid < 0 ? Integer.MIN_VALUE : nums1[nums1_mid];
//        int R1 = Integer.MAX_VALUE;
//        int L2 = nums2_index < 0 ? Integer.MIN_VALUE : nums2[nums2_index];
//        int R2 = nums2_index < -1 ? Integer.MAX_VALUE : nums2[nums2_index + 1];
//        if ((nums1.length + nums2.length) % 2 == 0) {
//            return (double)((Math.max(L1, L2) + Math.min(R1, R2))) / (double)2;
//        } else {
//            return Math.max(L1, L2);
//        }

    }

    private int indexOfDivider(int length1, int length2, int index1) {
        int firstHalf = (length1 + length2) / 2;
        if ((length1 + length2) % 2 != 0) {
            firstHalf = firstHalf + 1;
        }
        return firstHalf - index1 - 2;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int indexr = 0;
        int[] result = new int[length1 + length2];

        while (index1 < length1 && index2 < length2) {
            if(nums1[index1]<nums2[index2]){
                result[indexr++] = nums1[index1++];
            }else{
                result[indexr++] = nums2[index2++];
            }
        }
        while(index1 < length1){
            result[indexr++] = nums1[index1++];
        }
        while(index2 < length2){
            result[indexr++] = nums2[index2++];
        }
        int length = result.length;
        if(length%2 == 0)
            return (result[length/2]+result[(length/2)-1])/2.0;
        else return result[length/2];
    }
}
