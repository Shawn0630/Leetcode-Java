public class MediumofTwoSortedArrays {

    /*
    *
    *
    *  len1: 4
    *  len2: 6
    *  index: 0   1   2   3   4   5
    *             L1   R1
    *  nums1: 3   5  | 8   9                              cur1:  2
    *                 L2  R2
    *  nums2: 1   2   7 | 10  11  12  15                    cur1:  3
    *  nums3: 1   2   3   5   7   | 8   9   10   11   12  15 cur3:  5
    *
    *  think even first then odd.
    *
    *  L2 <= R1
    *  L1 <= R2
    *
    *
    *  index: 0   1   2
    *  nums1: 1   3
    *  nums2: 2
    *
    *
    *  1   2|   3
    *
    *  curL: 0, curR: 0
    *  L1  R1
    *    | 2
    *      L2  R2
    *  1   3 |
    *
    *  index: 0   1   2
    *  nums1: 1
    *  nums2: 1
    *
    *  L1  R1
    *    | 1  cur1 = 0
    *  L2  R2
    *  1 |
    *
    * */

    public double findMediumSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMediumSortedArrays(nums2, nums1);
        }

        int cur1 = 0;
        int cur2 = 0;
        int curL = 0;
        int curR = nums1.length; // the index is mid + 1, if nums1.length - 1, then index is mid


        while (cur1 <= nums1.length) {
            cur1 = (curL + curR) / 2;
            cur2 = (nums1.length + nums2.length) / 2 - cur1;

            double L1 = cur1 == 0 ? Integer.MIN_VALUE : nums1[cur1 - 1];
            double R1 = cur1 >= nums1.length ? Integer.MAX_VALUE : nums1[cur1];
            double L2 = cur2 == 0 ? Integer.MAX_VALUE : nums2[cur2 - 1];
            double R2 = cur2 >= nums2.length ? Integer.MAX_VALUE : nums2[cur2];

            if (L1 > R2) {
                curL = curL - 1;
            } else if (R1 < L2) {
                curR = curR + 1;
            } else {
                double left = L1 > L2 ? L1 : L2;
                double right = R1 > R2 ? R2 : R1
                        ;
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (left + right) / 2;
                } else {
                    return right;
                }
            }

        }

        return -1;
    }
}
