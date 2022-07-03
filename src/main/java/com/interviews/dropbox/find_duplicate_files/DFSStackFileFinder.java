package com.interviews.dropbox.find_duplicate_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DFSStackFileFinder implements FileFinder {


    @Override
    public List<String> findFilesByPath(String pathString) throws IOException {
        Path path = Paths.get(pathString);

        List<String> ans = new ArrayList<>();
        if (Files.isDirectory(path)) {
            for(String fileName : path.toFile().list()) {
                ans.addAll(findFilesByPath(path.toString() + "/" + fileName));
            }
        } else if (Files.isRegularFile(path) && !Files.isSymbolicLink(path)) {
            ans.add(path.toString());
        }
        return ans;
    }

    public Map<Long, List<String>> getAllFilesBySize(String pathStr) throws IOException {
        Map<Long, List<String>> fileSizeMap = new HashMap<>();

        Path root = Paths.get(pathStr);
        Files.walk(root)
                .filter(path -> Files.isRegularFile(path) && !Files.isSymbolicLink(path))
                .forEach(path -> {
                    File file = path.toFile();
                    long size = file.length();
                    fileSizeMap.putIfAbsent(size, new ArrayList<>());
                    fileSizeMap.get(size).add(file.getAbsolutePath());
                });

        return fileSizeMap;
    }

    public List<String> findAllDups(Map<Long, List<String>> filesBySize) throws IOException, NoSuchAlgorithmException {
        Map<String, List<String>> dupFilesMap = new HashMap<>();

        for(List<String> files : filesBySize.values()) {
            if(files.size() < 2) continue;

            for(String filePath : files) {
                File file = new File(filePath);
                String hashcode = FileUtils.hashFile(file, "MD5");
                dupFilesMap.putIfAbsent(hashcode, new ArrayList<>());
                dupFilesMap.get(hashcode).add(filePath);
            }
        }

        List<String> res = new ArrayList<>();
        for(List<String> dupFiles : dupFilesMap.values()) {
            if (dupFiles.size() > 1) {
                res.addAll(dupFiles);
            }
        }

        return res;
    }
}
