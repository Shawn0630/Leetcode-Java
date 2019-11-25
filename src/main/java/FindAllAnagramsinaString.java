import java.util.*;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return list;
        }

        int[] patternMap = new int[26];
        int[] stringMap = new int[26];

        for(Character ps : p.toCharArray()) {
            patternMap[ps - 'a']++;
        }
        for(int i = 0; i < p.length(); i++) {
            stringMap[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(stringMap, patternMap)) {
            list.add(0);
        }


        for(int i = 1; i + p.length() - 1 < s.length(); i++) {
            stringMap[s.charAt(i - 1) - 'a']--;
            stringMap[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(stringMap, patternMap)) {
                list.add(i);
            }
        }

        return list;
    }

    private boolean isAnagram(Map<Character, Integer> s, Map<Character, Integer> p) {
        for(Map.Entry<Character, Integer> entry : p.entrySet()) {
            if (s.get(entry.getKey()) == null) {
                return false;
            }
            if (!s.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }
}
