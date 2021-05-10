package com.search;

import com.TestUtils;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class FindPeakElementTest {
    FindPeakElement fpe = new FindPeakElement();
    private static final String TEST_FILE = "find_peak_element_test.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    public void testFindPeak(int[] nums, int[] possibleAns) {
        assertTrue(Arrays.stream(possibleAns).boxed().collect(Collectors.toList()).contains(fpe.findPeakElement(nums)));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(TEST_FILE).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToIntArray(csvRecord.get(0)),
                        TestUtils.convertToIntArray(csvRecord.get(1))));
    }
}
