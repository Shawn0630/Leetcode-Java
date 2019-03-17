public class LongestPalindromicSubstrings {
    public String longestPalidromic(String s) {
        /*
        *
        * aba
        * a
        * ab
        * b
        * aba
        * ba
        * a
        *
        * [0, 2] = [1, 1] (0, 0) (0, 1) (1, 1)
        *    0 1 2 3 4 ... s.length()
        * 0
        * 1
        * 2
        * 3
        * 4
        * ,
        * .
        * .
        *
        *
        *
        * abba
        *
        * */

        int max = 0;
        String res = "";
        if (s == null || s.length() == 0) return res;
        boolean[][] isPalidromic = new boolean[s.length()][s.length()];
        for(int j = 0; j < s.length(); j++) {
            for (int i = j; i >=0; i--) {
                isPalidromic[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalidromic[i + 1][j - 1]);
                if (isPalidromic[i][j]) {
                    if(j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
