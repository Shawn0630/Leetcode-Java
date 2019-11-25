import java.util.*;

public class AmazonTopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));


//        for(int i = 0; i < nums.length; i++) {
//            map.putIfAbsent(nums[i], 0);
//            map.put(nums[i], map.get(nums[i]) + 1);
//            queue.
//        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                break;
            }
            list.add(queue.poll());
        }

        return list;
    }
}
