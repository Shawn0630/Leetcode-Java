import java.util.List;

public class MissingN {
    public static int findMissing(List<Integer> array1, List<Integer> array2) {
        // Write your code here
        if (array1 == null || array2 == null || array1.size() == 0) {
            return -1;
        }
        int x = array1.get(0);
        for (int i = 1; i < array1.size(); i++) {
            x ^= array1.get(i);
        }

        for (int i = 0; i < array2.size(); i++) {
            x^= array2.get(i);
        }

        return x;
    }
}
