package com.strings;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestAbsoluteFilePath {
    // dir\n\tsubdir1
    //      \n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext


    // dir 0, dir
    //      subdir1 1, subdir1
    //          file1.ext, 2 file1.ext
    //      subdir2
    //          subsubdir2
    //              file2.ext
    // <([{\^-=$!|]})?*+.>
    public int lengthLongestPath(String input) {

        // Because Java needs regex to be a String literal. You have your \n but \ is also special in regex.
        // To complicate things, the way you escape in regex is also with \.
        // So you need to escape it again to make \\n which seems like it should be enough.. for regex..
        // but Java takes regex patterns as Strings. It sees you as escaping the \\n to make just n.
        // With \\\n Java sees a \\n and regex thinks you mean \n, but \ is still seen as a special character in regex.
        // So regex \\ = \ and Java \\ = \ which leaves you with the \\n that java finally sees as \n. Ended up escaping stuff just now, heh.
        String[] dirs = input.split("\n");
        Deque<Node> stack = new LinkedList<>();
        int max = 0;
        for(String dir : dirs) {
            int layer = 0;
            int cur = 0;
            while (cur + 1 <= dir.length() && dir.substring(cur, cur + 1).equals("\t")) {
                cur = cur + 1;
                layer++;
            }
            while (!stack.isEmpty() && stack.peek().layer >= layer) {
                stack.pop();
            }
            String fileOrDir = dir.substring(cur);
            int curLength = stack.isEmpty() ? fileOrDir.length() : stack.peek().curLength  + 1 + fileOrDir.length();
            if (fileOrDir.contains(".")) {
                max = Math.max(max, curLength);
            } else {
                stack.push(new Node(layer, fileOrDir, curLength));
            }
        }

        return max;
    }


    private class Node {
        private int layer;
        private String name;
        private int curLength;

        public Node(int layer, String name, int curLength) {
            this.layer = layer;
            this.name = name;
            this.curLength = curLength;
        }
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath longestAbsoluteFilePath = new LongestAbsoluteFilePath();
        longestAbsoluteFilePath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");

        String s = "3.14";
        String[] ss = s.split("\\.");
        List<String> array = new ArrayList<>();
        for(String string : ss) {
            array.add(string);
        }

        System.out.println(String.join(",", array));
    }
}
