import java.util.Arrays;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] isMatch = new boolean[s.length() + 1][p.length() + 1];
        isMatch[0][0] = true;

        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) != '*') {
                break;
            } else {
                isMatch[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    isMatch[i + 1][j + 1] = isMatch[i][j];
                } else if (p.charAt(j) == '*') {
                    isMatch[i + 1][j + 1] = isMatch[i][j + 1] || isMatch[i][j] || isMatch[i + 1][j];
                }
            }
        }

        return isMatch[s.length()][p.length()];
    }
}
