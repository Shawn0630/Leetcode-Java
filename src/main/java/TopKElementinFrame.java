import java.util.*;

public class TopKElementinFrame {
    List<List<Integer>> topK(int arr[], int k) {
        if (arr == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // first element
        map.put(arr[0], 1);
        List<Integer> first = Arrays.asList(arr[0]);
        res.add(first);

        for(int i = 1; i < arr.length; i++) {
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
            List<Integer> top = new ArrayList<>(res.get(i - 1));
            if (top.indexOf(arr[i]) == -1) {
                top.add(arr[i]);
            }
            top.sort((i1, i2) -> {
                if (!map.get(i1).equals(map.get(i2))) {
                    return map.get(i2) - map.get(i1);
                } else {
                    return i1 - i2;
                }
            });
            res.add(top.subList(0, k > top.size() ? top.size() : k));
        }

        return res;
    }
}
