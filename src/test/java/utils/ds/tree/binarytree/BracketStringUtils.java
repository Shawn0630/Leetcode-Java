package utils.ds.tree.binarytree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BracketStringUtils {
    // https://stackoverflow.com/questions/56873764/how-to-randomly-generate-a-binary-tree-given-the-node-number
    private static final Random random = new Random();
    private static final int MAX_RAND_NUM = 250;

    public static final Character LEFT_BRACKET = '(';
    public static final Character RIGHT_BRACKET = ')';

    public static String generateWellBalancedWord(int n ) {
        boolean[] word = buildRandomBalancedWord(n);
        rearrange(word, 0, word.length);
        return toString(word);
    }

    // true means '(', false means ')'
    private static boolean[] buildRandomBalancedWord(int n) {
        boolean[] word = new boolean[n * 2];
        List<Integer> positions = IntStream.range(0, 2 * n).boxed()
                .collect(Collectors.toList());
        for (int i = n; i > 0; i--) {
            int index = random.nextInt(n + i);
            word[positions.remove(index)] = true;
        }
        return word;
    }

    private static void rearrange(boolean[] word, int start, int end) {
        int sum = 0;
        int defectIndex = -1;
        for (int i = start; i < end; i++) {
            sum = sum + (word[i] ? 1 : -1);
            if (defectIndex < 0 && sum < 0) {
                defectIndex = i;
            } else if (defectIndex >= 0 && sum == 0) {
                // We now have irreducible u = rtl spanning [defectIndex, i]
                int uLength = i - defectIndex + 1;
                boolean[] flipped = new boolean[uLength - 2];
                for (int j = 0; j < flipped.length; j++)
                    flipped[j] = !word[defectIndex + j + 1];

                // Shift the remaining word
                if (i + 1 < end)
                    System.arraycopy(word, i + 1, word, defectIndex + 1, end - (i + 1));

                // Rewrite uw as lwrt*, t* being the flipped array
                word[defectIndex] = true;
                System.arraycopy(flipped, 0, word, end - flipped.length, flipped.length);
                word[end - uLength + 1] = false;

                // Now recurse on w, worst case we go (word.length/2)-deep
                rearrange(word, defectIndex + 1, end - uLength + 1);
                break;
            }
        }
    }

    private static boolean[] buildRandomWellFormedWord(int n) {
        boolean[] word = buildRandomBalancedWord(n);
        rearrange(word, 0, word.length);
        return word;
    }

    private static String toString(boolean[] word) {
        StringBuilder str = new StringBuilder();
        for (boolean b : word)
            str.append(b ? LEFT_BRACKET : RIGHT_BRACKET);
        return str.toString();
    }

    public static void main(String[] args) throws Exception {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        int N = 10000000, n = 4;
        for (int i = 0; i < N; i++) {
            boolean[] word = buildRandomWellFormedWord(n);
            String str = toString(word);
            Integer count = counts.get(str);
            if (count == null)
                count = 0;
            counts.put(str, count + 1);
        }

        counts.forEach((key, value) -> System.out.println("P[" + key + "] = " + value.doubleValue() / N));
    }
}
