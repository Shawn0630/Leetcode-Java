package com.interviews.dropbox.find_duplicate_files;

public class DFSStackFileFinderTest extends FileFinderTests {
    @Override
    public FileFinder getFileFinder() {
        return new DFSStackFileFinder();
    }
}
