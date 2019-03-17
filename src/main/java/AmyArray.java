import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AmyArray {

    public static List<Integer> counts(List<Integer> nums, List<Integer> maxes) {
        Collections.sort(nums); // nlog(n)
        Collections.sort(maxes); // nlog(n)

        /*
        *                   cur
        * index: 0   1   2   3
        * nums:  1   2   3
        * maxes: 2   3   3   3
        * count: 2   3   3   3
        *
        * nums:  3   4
        * maxes: 1   2
        * count: 0   0
        * */

        if (maxes == null || maxes.size() == 0) {
            return new ArrayList<>();
        }

        int[] count = new int[maxes.size()];
        int cur = 0;
        while(cur < nums.size() && nums.get(cur) <= maxes.get(0)) cur++;
        count[0] = cur;
        for (int i = 1; i < maxes.size(); i++) {
            while(cur < nums.size() && nums.get(cur) <= maxes.get(i)) cur++;
            count[i] = cur;
        }

        return Arrays.stream(count).boxed().collect(Collectors.toList());


    }
}
