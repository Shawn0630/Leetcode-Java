import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 ||
            t == null || t.length() == 0) {
            return "";
        }

        int start = 0;
        int minStart = -1;
        int len = 0;
        int shortest = Integer.MAX_VALUE;


        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> find = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int end = 0; end < s.length(); end++) {
            if (need.containsKey(s.charAt(end))) {
                find.put(s.charAt(end), find.getOrDefault(s.charAt(end), 0) + 1);
                if (find.get(s.charAt(end)) <= need.get(s.charAt(end))) {
                    len++;
                }
            }

            while(len == t.length()) {
                if (need.containsKey(s.charAt(start)) &&
                    find.containsKey(s.charAt(start)) &&
                    find.get(s.charAt(start)) >= need.get(s.charAt(start))) {
                        find.put(s.charAt(start), find.get(s.charAt(start)) - 1);
                        if (find.get(s.charAt(start)) < need.get(s.charAt(start))) {
                            len--;
                        }
                }
                if (shortest > end - start + 1) {
                    shortest = end - start + 1;
                    minStart = start;
                }
                start++;
            }

        }

        return shortest == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + shortest);

    }
}
