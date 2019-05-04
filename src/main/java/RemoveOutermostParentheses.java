public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;

        for(int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (left != 0) {
                    sb.append(S.charAt(i));
                }
                left++;
            } else if (S.charAt(i) == ')') {
                left--;
                if (left != 0) {
                    sb.append(S.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
