import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if(map.get(o1) == map.get(o2)) {
                return o1.compareTo(o2);
            } else {
                return map.get(o2) - map.get(o1);
            }
        });

        for(String word : map.keySet()) {
            queue.add(word);
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            list.add(queue.poll());
        }

        return list;

    }
}
