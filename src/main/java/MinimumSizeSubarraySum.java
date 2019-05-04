import static java.lang.Math.abs;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {

       /*
       *        1,    2,    3,    4,    5
       * start
       * end
       *
       * */
       if (nums == null || nums.length == 0) {
           return 0;
       }

       int start = 0;
       int end = 0;
       int shorest = Integer.MAX_VALUE;
       int sum = 0;

       while (end < nums.length) {
           sum += nums[end];
           while (sum >= s) {
               if (shorest > end - start + 1) {
                   shorest = end - start + 1;
               }
               sum -= nums[start++];
           }
           end++;
       }


       return shorest == Integer.MAX_VALUE ? 0 : shorest;
    }
}
