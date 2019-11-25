import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }

        Comparator<Integer> comparator = (o1, o2) -> {
            char[] c1 = o1.toString().toCharArray();
            char[] c2 = o2.toString().toCharArray();
            if (c1.length == c2.length) {
               for (int i = 0; i < c1.length; i++) {
                   if (c1[i] != c2[i]) {
                       return c2[i] - c1[i];
                   }
               }
               return 0;
            } else {
                int i = 0;
                while (c1[i % c1.length] == c2[i % c2.length] && i <= Math.max(c1.length, c2.length)) i++;
                return c2[i % c2.length] - c1[i % c1.length];
            }
        };

        list.sort(comparator);

        StringBuilder sb = new StringBuilder();
        if (list.get(0) == 0) {
            return "0";
        }
        for(Integer num : list) {
            sb.append(num);
        }

        return sb.toString();

    }
}
