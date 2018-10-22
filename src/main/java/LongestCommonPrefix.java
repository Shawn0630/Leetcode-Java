public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int end = str1.length() > str2.length() ? str2.length() : str1.length();

        for (int i = 0; i < end; i++) {
            if (str1.charAt(i) == str2.charAt(i)) continue;
            else return str1.substring(0, i);
        }

        return str1.length() > str2.length() ? str2 : str1;
    }
}
