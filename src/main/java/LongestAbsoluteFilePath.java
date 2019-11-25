import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int pos = 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(String str : input.split("\n")) {
            int level = str.lastIndexOf("\t") + 1;
            int start = pos;
            while (level + 1 < stack.size()) stack.pop();
            int length = stack.peek() + str.length() - str.lastIndexOf("\t") + 1;
            boolean isFile = isFile(str);
            if (isFile) {
                maxLen = Math.max(maxLen, length - 1);
            }
        }

        return maxLen;
    }

    private boolean isFile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        return str.contains(".");
    }
}
