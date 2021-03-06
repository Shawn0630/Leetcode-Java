import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthsis(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper(res, "", n, n);

        return res;
    }

    private static void helper(List<String> res, String cur, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(cur);
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            helper(res, cur + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, cur + ")", left, right - 1);
        }

    }
}
