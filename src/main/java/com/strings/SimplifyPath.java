package com.strings;

import java.util.Deque;
import java.util.LinkedList;

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
}
