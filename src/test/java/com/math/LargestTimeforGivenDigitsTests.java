package com.math;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestTimeforGivenDigitsTests {

    private LargestTimeforGivenDigits ltgd = new LargestTimeforGivenDigits();
    private static final String FILENAME = "largest_time_for_given_digits.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    void testTaskScheduler(int[] array, String expected) {
        assertEquals(expected, ltgd.largestTimeFromDigits(array));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntArray(record.get(0)), record.get(1).replace(" ", "")));
    }
}
