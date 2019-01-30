import java.util.*;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        String[] arr = new String[wordsA.length + wordsB.length];
        int index = 0;

        for (String word : wordsA) {
            mapA.put(word, mapA.getOrDefault(word, 0) + 1);
        }
        for (String word : wordsB) {
            mapB.put(word, mapB.getOrDefault(word, 0) + 1);
        }

        for (String word : wordsA) {
            if (mapB.containsKey(word)) { // cannot use mapB.entrySet().contains()
                continue;
            }
            if (mapA.get(word) > 1) {
                continue;
            }
            arr[index++] = word;
        }
        for (String word : wordsB) {
            if (mapA.containsKey(word)) {
                continue;
            }
            if (mapB.get(word) > 1) {
                continue;
            }
            arr[index ++] = word;
        }

        return Arrays.copyOfRange(arr, 0, index);
    }
}
