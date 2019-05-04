public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        /*        c  *  a  *  b
        *      0  1  2  3  4  5
        *    0 1  0  1  0  1  0
        * a  1 0  0  1  1  1  0
        * a  2 0  0
        * b  3 0
        *    4 0
        *    5 0
        *
        *    think about cases:
        *    (1, 2) = (1, 1) || (0, 0)
        *    (1, 3) = (0, 2)
        *    (1, 4) ~ (a, c*a*)  = (1, 3) ~ (a, c*a) | (0, 2) ~(^, c*a)
        *
        * */

        boolean[][] isMatch = new boolean[s.length() + 1][p.length() + 1];
        isMatch[0][0] = true;
        for(int j = 0; j < p.length(); j++) {
            if (j > 0 && p.charAt(j) == '*' && isMatch[0][j - 1]) {
                isMatch[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) {
                    isMatch[i + 1][j + 1] = isMatch[i][j];
                } else if (p.charAt(j) == '.') {
                    isMatch[i + 1][j + 1] = isMatch[i][j];
                } else if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        isMatch[i + 1][j + 1] = isMatch[i + 1][j - 1];
                    } else {
                        isMatch[i + 1][j + 1] = isMatch[i + 1][j - 1] ||
                                                isMatch[i + 1][j] ||
                                                isMatch[i][j + 1];
                    }

                }
            }
        }

        return isMatch[s.length()][p.length()];


    }
}
