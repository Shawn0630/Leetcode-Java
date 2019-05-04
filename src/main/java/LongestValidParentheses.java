public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res[] = new int[s.length() + 1];
        res[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                res[i + 1] = 0;
            } else if (s.charAt(i) == ')') {
               if (i > 0 && s.charAt(i - 1) == '(') {
                   res[i + 1] = res[i - 1] + 2;
               } else if (i > 0 && s.charAt(i - 1) == ')'){
                   if (i - res[i] - 1 >= 0 && s.charAt(i - res[i] - 1) == '(') {
                       res[i + 1] = res[i - res[i] - 1] + res[i] + 2;
                   }
               }
            }
        }
        int longest = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > longest) {
                longest = res[i];
            }
        }

        return longest;
    }
}
