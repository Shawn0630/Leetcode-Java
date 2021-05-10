package com.sliding_window;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestMountaininArrayTest {

    LongestMountaininArray lm = new LongestMountaininArray();

    private static final String FILE_NAME = "longest_mountain_in_array.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    public void testLongestMountainInArray(int[] arr, int expected) {
        assertEquals(lm.longestMountain(arr), expected);
    }


    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILE_NAME).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToIntArray(csvRecord.get(0)),
                        Integer.valueOf(csvRecord.get(1).replace(" ", ""))));
    }
}
