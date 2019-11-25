import java.util.Collections;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null) {
            return false;
        }
        if (s.length() == 0 && wordDict.size() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if ((i >= word.length() - 1 && s.substring(i - word.length() + 1, i + 1).equals(word)) &&
                        (i + 1 - word.length() >= 0 && dp[i + 1 - word.length()])) {
                    dp[i + 1] = true;
                    break;
                } else {
                    dp[i + 1] = false;
                }
            }
        }

        return dp[s.length()];

    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        return Collections.emptyList();
    }
}
