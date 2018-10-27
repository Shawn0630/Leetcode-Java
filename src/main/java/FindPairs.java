import java.util.*;

public class FindPairs {
    public int findPairs(int[] nums, int k) {

/**
 *  Method 1: Two pointers
 *
 */
/*        Arrays.sort(nums);

        int p1 = 0;
        int p2 = 1;
        int counter = 0;

        while (p2 < nums.length) {
          if (nums[p2] - nums[p1] >= k) {
              if (nums[p2] - nums[p1] == k) {
                  counter++;
              }
              p1++;
              while (p1 < nums.length && nums[p1 - 1] == nums[p1]) {
                  p1++;
              }
              p2 = p1 + 1;
          } else {
              p2++;
          }
        }

        return counter;
*/

/*
* Method 2: Faster Two Pointer
*
* */

//    Arrays.sort(nums);
//    int p1 = 0;
//    int p2 = 1;
//    int counter = 0;
//
//    while (p2 < nums.length) {
//        if (nums[p2] - nums[p1] < k) {
//            p2++;
//        } else if (nums[p2] - nums[p1] == k) {
//            counter++;
//            p1++;
//            while(p1 < nums.length && nums[p1 - 1] == nums[p1]) {
//                p1++;
//            }
//            p2 = Math.max(p1 + 1, p2 + 1);
//        } else {
//            p1++;
//        }
//        // possible p1 == p2
//        if (p1 == p2) {
//            p2++;
//        }
//    }
//
//    return counter;
//
//    }

/**
 * Method 3: Hashmap
 *
 */

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;

        if (k < 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : map.keySet()) {
            if (k == 0) {
                if (map.getOrDefault(i, 0) > 1) counter++;
            } else {
                if (map.containsKey(i + k)) counter++;
            }
        }

        return counter;
    }
}

