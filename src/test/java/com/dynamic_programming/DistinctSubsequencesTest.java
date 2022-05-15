package com.dynamic_programming;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctSubsequencesTest {

    private static final String TEST_FILE = "distinct_subsequences_tests.csv";
    private DistinctSubsequences ds = new DistinctSubsequences();

    @ParameterizedTest
    @MethodSource("generateData")
    void testTaskScheduler(String s, String t, int count) {
        assertEquals(count, ds.numDistinct(s, t));
        assertEquals(count, ds.numDistinct2(s, t));
    }



    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(TEST_FILE).stream()
                .map(csvRecord -> Arguments.of(csvRecord.get(0).replace(" ", ""),
                        csvRecord.get(1).replace(" ", ""),
                        Integer.valueOf(csvRecord.get(2).replace(" ", ""))));
    }
}
