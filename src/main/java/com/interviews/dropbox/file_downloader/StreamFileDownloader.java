package com.interviews.dropbox.file_downloader;

public interface StreamFileDownloader {
    boolean isFileDone();
    void addBlock(Chuck chuck);
}
