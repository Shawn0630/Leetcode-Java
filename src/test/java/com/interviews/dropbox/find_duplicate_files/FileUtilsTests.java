package com.interviews.dropbox.find_duplicate_files;

import com.TestUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class FileUtilsTests {
    @Test
    public void testHashFile() throws IOException, NoSuchAlgorithmException {

        System.out.println(FileUtils.hashFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("132_pattern.csv")).getFile()), "MD5"));
        //System.out.println(FileUtils.hashFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("test_hash_file.txt")).getFile()), "MD5"));
    }
}
