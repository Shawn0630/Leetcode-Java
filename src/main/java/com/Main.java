import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Main {

    // Add any helper functions you may need here


    int minOperations(int[] arr) {
        // Write your code here
        Set<String> set = new HashSet<>();//store visited string
        Queue<String> queue = new LinkedList<>(); // store next strs
        int counter = 0;

        queue.offer(getKey(arr));
        set.add(getKey(arr));

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> curs = new ArrayList<>();
            while (size > 0) {
                curs.add(queue.poll());
                size--;
            }

            for(String cur : curs) {
                if (isIncreasing(cur)) {
                    return counter;
                }

                for(int i = 0; i < cur.length(); i++) {
                    String next = reverseString(cur, i);
                    if (!set.contains(next)) {
                        set.add(next);
                        queue.offer(next);
                    }
                }
            }

            counter++;
        }

        return counter;
    }

    // [1, 2  3]
    // "123"
    private String getKey(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(String.valueOf(a));
        }

        return sb.toString();
    }


    // 132 => false
    // 123 => true
    private boolean isIncreasing(String s) {
        char[] carray = s.toCharArray();
        int prev = carray[0] - '0';

        for(int i = 1; i < carray.length; i++) {
            int cur = carray[i] - '0';
            if (prev > cur) {
                return false;
            }
            prev = cur;
        }

        return true;
    }


    private String reverseString(String s, int i) {
        if (i < 0 || i >= s.length()) {
            return s;
        }
        char[] carray = s.toCharArray();
        int left = i;
        int right = s.length() - 1;

        while (left < right) {
            char temp = carray[left];
            carray[left] = carray[right];
            carray[right] = temp;
            left++;
            right--;
        }

        return new String(carray);

    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}