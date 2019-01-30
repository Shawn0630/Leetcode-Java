import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NRepeatedElement {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : A) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
        Arrays.stream(A).forEach(a -> map.put(a, map.getOrDefault(a, 0) + 1));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == A.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
