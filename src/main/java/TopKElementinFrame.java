import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElementinFrame {
    public List<List<Integer>> topK(int arr[], int k) {
        if (arr == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] frequencies = new int[k];

        List<Integer> topK = new ArrayList<>();
        map.putIfAbsent(arr[0], 0);
        map.put(arr[0], map.get(arr[0]) + 1);
        topK.add(arr[0]);
        list.add(topK);
        frequencies[0] = map.get(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);


        }

        return list;
    }
}
