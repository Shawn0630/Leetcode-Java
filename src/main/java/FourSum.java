import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> fourSums = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> threeSums = threeSum(nums, i + 1, target - nums[i]);
                for (List<Integer> list: threeSums) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.addAll(list);
                    fourSums.add(ans);
                }
            }
        }

        return fourSums;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> threeSums = new ArrayList<>();

        for (int i = start; i < nums.length - 2; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                Set<List<Integer>> twoSums = twoSum(nums, i + 1, target - nums[i]);
                for (List<Integer> list: twoSums) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.addAll(list);
                    threeSums.add(ans);
                }
            }
        }

        return threeSums;
    }

    public Set<List<Integer>> twoSum(int[] nums, int start, int target) {
        Set<List<Integer>> twoSums = new HashSet<>();
        int end = nums.length - 1;

        while(start < end) {
            if (nums[start] + nums[end] == target) {
                twoSums.add(Arrays.asList(nums[start], nums[end]));
                start++;
                end--;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }

        return twoSums;
    }
}
