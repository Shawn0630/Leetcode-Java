package com.strings;

public class CompareVersionNumbers {
    //"1.0"
    //"1.0.0"
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        for(int i = 0; i < Math.max(version1Array.length, version2Array.length); i++) {
            int v1 = i >= version1Array.length ? 0: Integer.parseInt(version1Array[i]);
            int v2 = i >= version2Array.length ? 0: Integer.parseInt(version2Array[i]);

            if(v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }
}
