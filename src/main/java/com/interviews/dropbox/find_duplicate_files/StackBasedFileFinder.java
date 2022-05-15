package com.interviews.dropbox.find_duplicate_files;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackBasedFileFinder implements FileFinder {
    @Override
    public List<String> findFilesByPath(String path) {

        List<String> files = new ArrayList<>();
        Stack<String> s = new Stack<>();
        s.push(path);

        while (!s.isEmpty()) {
            String currPath = s.pop();
            File file = new File(currPath);
            if (Files.isSymbolicLink(file.toPath())) {
                continue; // skip soft/symbolic link to avoid cycle
            } else if (file.isFile()) {
                files.add(currPath);
            } else if (file.isDirectory()) {
                String[] subDir = file.list();
                for(String dir : subDir) {
                    s.push(currPath + "/" + dir);
                }
            } else {

            }
        }


        return files;
    }
}
