import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
    /*
    *  Method 1 : Hashmap(Really Slow)
    *
    * */

//        String shorter = s.length() < t.length() ? s : t;
//        String longer = s.length() < t.length() ? t : s;
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < shorter.length(); i++) {
//            map.put(shorter.charAt(i), map.getOrDefault(shorter.charAt(i), 0));
//        }
//
//        for (int i = 0; i < longer.length(); i++) {
//            if (map.containsKey(longer.charAt(i))) {
//               map.put(longer.charAt(i), map.get(longer.charAt(i)) - 1);
//               if (map.get(longer.charAt(i)) == 0) {
//                   map.remove(longer.charAt(i));
//               }
//            } else {
//                return longer.charAt(i);
//            }
//        }
//
//        return ' ';


        /*
        *   Method 2 : XOR (Fast)
        *
        * */

//        int ans = 0;
//        for (int i = 0; i < s.length(); i++) {
//            ans ^= s.charAt(i);
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            ans ^= t.charAt(i);
//        }
//
//        return (char)ans;
        char ans = 0;
        for (char c : s.toCharArray()) {
            ans ^= c;
        }

        for (char c : t.toCharArray()) {
            ans ^= c;
        }

        return ans;
    }
}
