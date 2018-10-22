public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        // binary search with duplication
        while (start < end) {
            int mid = (start + end) / 2;

            if (letters[mid] == target) {
                if (mid == letters.length - 1 || letters[mid] == letters[mid + 1]) {
                    start = start + 1;
                } else {
                    return letters[(mid + 1) % letters.length];
                }
            } else if (letters[mid] < target) {
                start = mid + 1 ;
            } else {
                end = mid;
            }
        }

        return target >= letters[start] ? letters[(start + 1) % letters.length] : letters[start];
    }
}
