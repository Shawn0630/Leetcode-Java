import java.util.*;

public class TopKFrequent {
    // https://leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*
        * Method 1: Priority Queue
        * */

//        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
//        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            heap.add(entry);
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }
//
//        List<Integer> result = new ArrayList<>();
//        while(heap.size()>0){
//            result.add(heap.poll().getKey());
//        }
//
//        Collections.reverse(result);


        /*
        * Method 2: Bucket Sort
        * */

        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }

        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[maxCount + 1];
        for(int i = 1; i <= maxCount; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();

        for (int i = maxCount; i >= 1; i--) {
            if(arr[i].size() != 0) {
                for (int a : arr[i]) {
                    result.add(a);
                    if (result.size() == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }



    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 3
        // 1 2 4 3
        // 1 => 2 1 => 4 2 1 => 4 3 2 1(3 2 1) wrong
        // 1 => 1 2 => 1 2 4 => 1 2 3 4(2 3 4) correct
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue()); // pitfall here!!!!!!

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            ans[idx++] = queue.poll().getKey();
        }

        return ans;
    }


    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] =  new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }


        int[] ans = new int[k];
        int idx = 0;
        for(int i = nums.length; i >= 0 && k > 0; i--) {
            List<Integer> list = bucket[i];
            if (list != null) {
                for(Integer num : list) {
                    ans[idx++] = num;
                    k--;
                }
            }
        }

        return Arrays.copyOfRange(ans, 0, idx);
    }
}
