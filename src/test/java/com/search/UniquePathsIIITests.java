package com.search;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePathsIIITests {
    private final static String FILENAME = "unique_paths_III_test_cases.csv";

    UniquePathsIII up = new UniquePathsIII();

    @ParameterizedTest
    @MethodSource("generateData")
    void testTaskScheduler(int[][] grid, int expected) {
        assertEquals(expected, up.uniquePathsIII(grid));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToCharArray(record.get(0)),
                        Integer.valueOf(record.get(1).replace(" ", "")),
                        Integer.valueOf(record.get(2).replace(" ", ""))));
    }
}
