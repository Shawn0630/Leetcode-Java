public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == chars[i]) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
