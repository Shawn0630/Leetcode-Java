import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Braces {
    static String[] braces(String[] values) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (isValid(values[i])) {
                results.add("YES");
            } else {
                results.add("NO");
            }
        }

        return results.toArray(new String[results.size()]);

    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                if(!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else return false;
            } else if(s.charAt(i) == '}') {
                if(!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else return false;
            } else if(s.charAt(i) == ']') {
                if(!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else return false;
            }
        }
        if(!stack.empty()) return false;
        else return true;
    }
}
