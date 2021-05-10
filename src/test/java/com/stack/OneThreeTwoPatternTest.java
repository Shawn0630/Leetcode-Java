package com.stack;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OneThreeTwoPatternTest {

    private final static String FILE_NAME = "132_pattern.csv";
    OneThreeTwoPattern pattern = new OneThreeTwoPattern();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testOneTreeTwoPattern(int[] nums, boolean expect) {
        assertThat(pattern.find132pattern2(nums), is(expect));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILE_NAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntArray(record.get(0)),
                        Boolean.valueOf(record.get(1).replace(" ", ""))));
    }
}
