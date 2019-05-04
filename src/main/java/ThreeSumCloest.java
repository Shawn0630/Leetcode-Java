import java.util.*;

public class ThreeSumCloest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while(start < end) {
                int res = first + nums[start] + nums[end];
                if (Math.abs(target - res) < diff) {
                    diff = Math.abs(target - res);
                    ans = res;
                }
                if (target < res) {
                    end--;
                } else if (target > res){
                    start++;
                } else  {
                    return target;
                }
            }
        }
        return ans;
    }

    List<List<Integer>> optimaUtilization(int maxTravelVisit, List<List<Integer>> forwardList, List<List<Integer>> returnList) {
       if (forwardList == null || returnList == null) {
           return Collections.emptyList();
       }

       forwardList.sort(Comparator.comparingInt(o -> o.get(1)));
       returnList.sort(Comparator.comparingInt(o -> o.get(1)));

       List<List<Integer>> res = new ArrayList<>();
       int forwardPos = 0;
       int returnPos = returnList.size() - 1;
       int max = 0;

       while (forwardPos < forwardList.size() && returnPos >= 0) {
           int sum = forwardList.get(forwardPos).get(1) + returnList.get(returnPos).get(1);
           if (sum > max && sum <= maxTravelVisit) {
               max = sum;
           } else if (sum > maxTravelVisit) {
               returnPos--;
           } else {
               forwardPos++;
           }
       }

       forwardPos = 0;
       returnPos = returnList.size() - 1;

       while(forwardPos < forwardList.size() && returnPos >= 0) {
           int sum = forwardList.get(forwardPos).get(1) + returnList.get(returnPos).get(1);
           if (sum == max) {
               int forwardStart = forwardPos;
               int returnStart = returnPos;
               while(forwardPos < forwardList.size() - 1 && forwardList.get(forwardPos).get(1).equals(forwardList.get(forwardPos + 1).get(1))) forwardPos++;
               while(returnPos > 0 && returnList.get(returnPos).get(1).equals(returnList.get(returnPos - 1).get(1))) returnPos--;
               for(int i = forwardStart; i <= forwardPos; i++) {
                   for (int j = returnStart; j >= returnPos; j--) {
                       res.add(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0)));
                   }
               }
               forwardPos++;
               returnPos--;
           } else if (sum < max) {
               forwardPos++;
           } else if (sum > max) {
               returnPos--;
           }
       }

       return res;
    }
}
