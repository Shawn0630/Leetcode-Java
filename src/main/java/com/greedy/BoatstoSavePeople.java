package com.greedy;

import java.util.Arrays;

public class BoatstoSavePeople {
    // [1,2] 3

    //
    // [3,  5,  3,  4] 5
    //  3   3   4   5
    // constraints:
    // 1. max <= limit
    // 2. at most 2 people

    // 3   3   4   5
    // i            j
    //          j
    //      j
    //
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int counter = 0;

        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            if (i == j) {
                counter++;
                break;
            }
            int left = people[i];
            int right = people[j];

            if (left + right > limit) {
                j--;
            } else if (left + right <= limit) {
                i++;
                j--;
            }
            counter++;
        }

        return counter;
    }
}
