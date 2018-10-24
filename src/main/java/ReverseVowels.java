public class ReverseVowels {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder SB = new StringBuilder(s);
        char[] c = s.toCharArray();  // use char array will faster

        while (left < right) {
            while (left < s.length() - 1 &&
                !(s.charAt(left) == 'a' || s.charAt(left) == 'A' ||
                s.charAt(left) == 'e' || s.charAt(left) == 'E' ||
                s.charAt(left) == 'i' || s.charAt(left) == 'I' ||
                s.charAt(left) == 'o' || s.charAt(left) == 'O' ||
                s.charAt(left) == 'u' || s.charAt(left) == 'U')) {
             left++;
            }
            while(right >= 0 &&
                    !(s.charAt(right) == 'a' || s.charAt(right) == 'A' ||
                    s.charAt(right) == 'e' || s.charAt(right) == 'E' ||
                    s.charAt(right) == 'i' || s.charAt(right) == 'I' ||
                    s.charAt(right) == 'o' || s.charAt(right) == 'O' ||
                    s.charAt(right) == 'u' || s.charAt(right) == 'U')) {
                right--;
            }

            if (left < right) {
                SB.setCharAt(left, s.charAt(right));
                SB.setCharAt(right, s.charAt(left));
                left++;
                right--;
            }
        }

        return SB.toString();
    }
}
