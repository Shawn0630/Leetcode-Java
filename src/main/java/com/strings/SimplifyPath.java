package com.strings;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        StringBuilder sb = new StringBuilder();
        Deque<StringBuilder> dirs = new LinkedList<>();
        path = path + "/";

        for (int i = 0; i < path.length(); i++) {
            char cur = path.charAt(i);

            if (cur == '/') {
                if (!dirs.isEmpty()) {
                    String str = dirs.getLast().toString();
                    if (str.isEmpty() || str.equals(".") || str.equals("..")) {
                        dirs.removeLast();
                        if (str.equals("..") && !dirs.isEmpty()) {
                            dirs.removeLast();
                        }
                    }
                }
                dirs.add(new StringBuilder());
            } else {
                dirs.getLast().append(cur);
            }
        }

        dirs.removeLast();
        sb.append('/');
        while (!dirs.isEmpty()) {
            StringBuilder dir = dirs.removeFirst();
            String dirName = dir.toString();
            sb.append(dirName);
            if (dirs.size() > 0) {
                sb.append('/');
            }
        }

        return sb.toString();
    }

    public String simplifyPath2(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String dir : dirs) {
            if(dir.length() == 0) continue; // "//"
            else if (dir.equals(".")) continue;
            else if (dir.equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }

        List<String> paths = new ArrayList<>();
        if (stack.empty()) {
            return "/";
        }
        while (!stack.empty()) {
            paths.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = paths.size() - 1; i >= 0; i--) {
            sb.append("/" + paths.get(i));
        }

        return sb.toString();
    }
}
