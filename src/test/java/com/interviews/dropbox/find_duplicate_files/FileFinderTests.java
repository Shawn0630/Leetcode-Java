package com.interviews.dropbox.find_duplicate_files;

import org.junit.Test;

import java.io.IOException;

public abstract class FileFinderTests {
    public abstract FileFinder getFileFinder();

    @Test
    public void e2eTest() throws IOException {
        System.out.println(getFileFinder().findFilesByPath("/Users/shawn/Files/Project/Leetcode-Java/target/test-classes/e2eTest"));

    }
}
