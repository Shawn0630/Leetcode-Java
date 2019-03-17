import java.util.Comparator;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o2.length() - o1.length(); // o1.length - o2.length[o1.length < o2.length]
        });
        String res = "";

        for (String word : d) {
            if (check(s, word)) return word;
        }

        return res;
    }

//    private boolean check(String s, String word) {
//        int i = 0;
//        for(Character c : s.toCharArray()) {
//            if (c.equals(word.charAt(i))) {
//                i = i + 1;
//            }
//            if (i == word.length()) return true;
//        }
//        return false;
//    }

    private boolean check(String s, String word) {
        int i = 0;
        int start = 0;
        while (i < word.length()) {
            if ((start = s.substring(start).indexOf(word.charAt(i))) != -1) {
                i = i + 1;
                start = start + 1;
            } else {
                return false;
            }
        }

        return true;

    }
}
