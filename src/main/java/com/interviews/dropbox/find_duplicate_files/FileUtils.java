package com.interviews.dropbox.find_duplicate_files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils {
    public static boolean isSymbolicLink(String path) {
        try {
            // directory path
            File file = new File(path);

            // check if directory is empty
            if (file.isDirectory()) {
                File canon = file.getParent() == null ? file :
                        new File(file.getParentFile().getCanonicalFile(), file.getName());
                return !canon.getCanonicalFile().equals(canon.getAbsoluteFile());
            } else {
                return false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static String hashFile(File file, String algorithm) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        FileInputStream fs = new FileInputStream(file);
        BufferedInputStream bs = new BufferedInputStream(fs);
        byte[] buffer = new byte[1024];
        int bytesRead;

        while((bytesRead = bs.read(buffer, 0, buffer.length)) != -1){
            digest.update(buffer, 0, bytesRead);
        }
        return covertByteArrayToHexString(digest.digest());
    }

    // byte  -128 ~ 127 -> 8 bits 1111 1111
    // https://stackoverflow.com/questions/25838473/what-does-0xff-do-and-md5-structure
    private static String covertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder sb = new StringBuilder();
        for (byte arrayByte : arrayBytes) {
            sb.append(String.format("%02x", arrayByte));
            //sb.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100).substring(1));
            // & 0xFF performs a binary AND, causing the returning value to be between 0 and 255 (which a byte always is anyway)
            // + 0x100 adds 256 to the result to ensure the result is always 3 digits
        }


        return sb.toString();
    }
}
