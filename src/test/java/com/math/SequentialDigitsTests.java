package com.math;

import com.TestUtils;
import com.greedy.TaskScheduler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialDigitsTests {
    private final static String FILENAME = "sequential_digits_test_cases.csv";

    SequentialDigits sd = new SequentialDigits();

    @ParameterizedTest
    @MethodSource("generateData")
    void testTaskScheduler(int low, int high, List<Integer> expected) {
        assertEquals(expected, sd.sequentialDigits(low, high));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(Integer.valueOf(record.get(0).replace(" ", "")),
                        Integer.valueOf(record.get(1).replace(" ", "")),
                        TestUtils.convertToIntegerList(record.get(2).replace(" ", ""))));
    }
}
