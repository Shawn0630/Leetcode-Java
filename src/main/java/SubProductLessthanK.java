public class SubProductLessthanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }

        /*
        *
        * 10       5       2      6
        *
        * start
        * end
        *         end
        *                  end
        *
        *        start
        *        end
        *
        * */

       int start = 0;
       int end = 0;
       int cur = 1;
       int count = 0;
//       while(start < nums.length) {
//           while (end < nums.length && cur < k) {
//               // two mode: end++ end should end - 1 && end < nums.length - 1; ++end, start at cur
//               cur *= nums[end++];
//           }
//           if (start < end) {
//               if (cur >= k) count += (end - start - 2 + 1);
//               else count += (end - start);
//           }
//           cur /= nums[start++];
//       }

       while (end < nums.length) {
           cur *= nums[end];
           while (start <= end && cur >= k) {
               cur /= nums[start++];
           }
           count += end - start + 1;
           end++;
       }

       return count;
    }
}
