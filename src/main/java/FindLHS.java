import java.util.Arrays;
import java.util.HashMap;

public class FindLHS {
    public int findLHS(int[] nums) {

        /*
        *  Method 1: Hashmap
        *
        * */
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for (int num : map.keySet()) {
//            if (map.containsKey(num + 1)) {
//                int len = map.get(num) + map.get(num + 1);
//                if (len > res) {
//                    res = len;
//                }
//            }
//        }
//
//        return res;

        /*
        * Method 2: Two pointer
        *
        * */

        Arrays.sort(nums);
        int start = 0;
        int end = 1;
        int res = 0;

        while (end < nums.length) {
            if (nums[end] - nums[start] == 1) {
                res = end - start + 1 > res ? end - start + 1 : res;
                end++;
            } else if (nums[end] - nums[start] > 1) {
                start++;
            } else {
                end++;
            }
        }

        return res;
    }
}
