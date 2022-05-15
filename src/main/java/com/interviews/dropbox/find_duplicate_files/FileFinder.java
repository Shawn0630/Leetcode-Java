package com.interviews.dropbox.find_duplicate_files;

import java.util.List;

public interface FileFinder {
    List<String> findFilesByPath(String path);
}
