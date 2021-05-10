package com.dynamic_programming;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NumberofLongestIncreasingSubsequenceTest {

    NumberofLongestIncreasingSubsequence numberofLongestIncreasingSubsequence = new NumberofLongestIncreasingSubsequence();

    private static final String FILENAME = "number_of_longest_increasing_subsequence.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    public void testNumberofLongestIncreasingSubsequence(int[] nums, int expected) {
        assertThat(numberofLongestIncreasingSubsequence.findNumberOfLIS(nums), is(expected));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntArray(record.get(0)),
                        Integer.valueOf(record.get(1).replace(" ", ""))));
    }
}
