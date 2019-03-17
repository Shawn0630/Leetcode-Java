import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnagramDifference {

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(getDifference(a.get(i), b.get(i)));
        }

        return result;
    }

    static Integer getDifference(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }

        int[] aFeq = new int[26];
        for (int i = 0; i < a.length(); i++) {
            aFeq[a.charAt(i)-'a'] = aFeq[a.charAt(i)-'a'] + 1;
        }
        int[] bFeq = new int[26];
        for (int i = 0; i < b.length(); i++) {
            bFeq[b.charAt(i) - 'a'] = bFeq[b.charAt(i) - 'a'] + 1;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(aFeq[i] - bFeq[i]);
        }

        return sum / 2;
    }
}
