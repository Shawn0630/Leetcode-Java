import java.util.*;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] shorter = nums1.length <= nums2.length ? nums1 : nums2;
        int[] longer = nums1.length > nums2.length ? nums1 : nums2;
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < shorter.length; i++) {
            set.add(shorter[i]);
        }

        for (int i = 0; i < longer.length; i++) {
            if (set.contains(longer[i])) {
                res.add(longer[i]);
                set.remove(longer[i]);
            }
        }

        int result[] = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {

/*
          Method 1 : Hashmap
 */

//        int[] shorter = nums1.length <= nums2.length ? nums1 : nums2;
//        int[] longer = nums1.length > nums2.length ? nums1 : nums2;
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        List<Integer> list = new ArrayList<Integer>();
//
//        for (int i = 0; i < shorter.length; i++) {
//            if (!map.containsKey(shorter[i])) {
//                map.put(shorter[i], 1);
//            } else {
//                map.put(shorter[i], map.get(shorter[i]) + 1);
//            }
//        }
//
//        for (int i = 0; i < longer.length; i++) {
//            if (map.containsKey(longer[i])) {
//                list.add(longer[i]);
//                map.put(longer[i], map.get(longer[i]) - 1);
//                if (map.get(longer[i]) == 0) {
//                     map.remove(longer[i]);
//                }
//            }
//        }
//
//        int result[] = new int[list.size()];
//        for(int i = 0; i < list.size(); i++)
//            result[i] = list.get(i);
//        return result;

/*
          Method 2 : Two pointer
 */

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int nums1_length = nums1.length;
        int nums2_length = nums2.length;
        int nums1_p = 0;
        int nums2_p = 0;
        int[] res = new int[nums1_length > nums2_length ? nums1_length : nums2_length];
        int res_p = 0;

        while (nums1_p < nums1_length && nums2_p < nums2_length) {
            if (nums1[nums1_p] == nums2[nums2_p]) {
                res[res_p] = nums1[nums1_p];
                nums1_p++;
                nums2_p++;
                res_p++;
            } else if (nums1[nums1_p] < nums2[nums2_p]){
                nums1_p++;
            } else {
                nums2_p++;
            }
        }

        return Arrays.copyOfRange(res, 0, res_p);

    }
}
