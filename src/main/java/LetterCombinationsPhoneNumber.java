import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    Character[][] phone = {{}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        dp(res, new StringBuilder(), 0, digits);

        return res;
    }

    private void dp(List<String> res, StringBuilder cur, int pos, String digits) {
        if (pos == digits.length()) {
            res.add(cur.toString());
        } else {
            int index = digits.charAt(pos) - '0' - 1;
            if (index == 0) {
                dp(res, cur, pos + 1, digits);
            } else {
                for (int i = 0; i < phone[index].length; i++) {
                    cur.append(phone[index][i]);
                    dp(res, cur, pos + 1, digits);
                    cur.deleteCharAt(cur.length() - 1);
                }
            }
        }
    }
}
