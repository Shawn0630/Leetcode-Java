public class BinarySearch {
    /**
     * Refer to https://leetcode.com/problems/binary-search/discuss/423162/Binary-Search-101
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        /**
         *But this is not always the case.
         * We need to remember: the boundary is the range of elements we will be searching from.
         * The initial boundary should include ALL the elements, meaning all the possible answers should be included. Binary search can be applied to none array problems, such as Math, and this statement is still valid.
         *
         * For example, In LeetCode 35, the question asks us to find an index to insert into the array.
         * It is possible that we insert after the last element of the array, thus the complete range of boundary becomes
         * let lo = 0, hi = nums.length;
         *
         */
        int left = 0;
        int right = nums.length - 1;
        /**
         * Why? Because this way, the only condition the loop exits is lo == hi. I know they will be pointing to the same element, and I know that element always exists.
         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;

                /**
                 *5. Avoid infinity loop
                 * Remember I said a bad choice of left or right mid will lead to an infinity loop? Let's tackle this down.
                 * Example:
                 *
                 * let mid = lo + ((hi - lo) / 2); // Bad! We should use right/upper mid!
                 *
                 * if (target < nums[mid]) {
                 * 	hi = mid - 1
                 * } else {
                 * 	lo = mid;
                 * }
                 * Now, imagine when there are only 2 elements left in the boundary. If the logic fell into the else statement, since we are using the left/lower mid, it's simply not doing anything. It just keeps shrinking itself to itself, and the program got stuck.
                 * We have to keep in mind that, the choice of mid and our shrinking logic has to work together in a way that every time, at least 1 element is excluded.
                 *
                 * let mid = lo + ((hi - lo + 1) / 2); // Bad! We should use left/lower mid!
                 *
                 * if (target > nums[mid]) {
                 * 	lo = mid + 1; // mid is excluded
                 * } else {
                 * 	hi = mid; // mid is included
                 * }
                 * So when your binary search is stuck, think of the situation when there are only 2 elements left. Did the boundary shrink correctly?
                 *
                 */
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] == target ? left : -1;

    }
}
