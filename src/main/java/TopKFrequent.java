import java.util.*;

public class TopKFrequent {
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
}
