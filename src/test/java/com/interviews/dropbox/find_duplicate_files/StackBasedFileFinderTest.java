package com.interviews.dropbox.find_duplicate_files;

public class StackBasedFileFinderTest extends FileFinderTests {
    @Override
    public FileFinder getFileFinder() {
        return new StackBasedFileFinder();
    }
}
