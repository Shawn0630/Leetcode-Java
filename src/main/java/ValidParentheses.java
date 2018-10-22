import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (stack.size() == 0 ||
                      (s.charAt(i) == ')' && stack.peek() != '(' ||
                       s.charAt(i) == '}' && stack.peek() != '{' ||
                       s.charAt(i) == ']' && stack.peek() != '[')) {
                return false;
            } else {
                stack.pop();
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }
}
