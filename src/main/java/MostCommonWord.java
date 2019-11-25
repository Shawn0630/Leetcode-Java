import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null) {
            return "";
        }

        Set<String> set = new HashSet<>();
        for(String bannedString : banned) {
            set.add(bannedString);
        }

        int mostCommandCount = Integer.MIN_VALUE;
        String res = null;
        Map<String, Integer> map = new HashMap<>();
        String[] words = words(paragraph);
        for(String word: words) {
            if (set.contains(word)) continue;
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
            if (map.get(word) > mostCommandCount) {
                res = word;
                mostCommandCount = map.get(word);
            }
        }

        return res;
    }

    public String[] words(String paragraph) {
//        return paragraph.toLowerCase()
//                .replaceAll(",", " ")
//                .replaceAll("\\.", " ")
//                .replaceAll("\\?", " ")
//                .replaceAll("!", " ")
//                .replaceAll("'", " ")
//                .replaceAll("( +)"," ")
//                .trim()
//                .split(" ");
        return paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
    }
}
