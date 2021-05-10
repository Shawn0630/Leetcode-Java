package com.array;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KPairsTest {
    KPairs kPairs = new KPairs();
    private final static String FILENAME = "k_pair_test_cases.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    void testKPair(int[] nums, int k, int expected) {
        assertEquals(expected, kPairs.findPairs(nums, k));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntArray(record.get(0)),
                        Integer.valueOf(record.get(1).replace(" ", "")),
                        Integer.valueOf(record.get(2).replace(" ", ""))));
    }


}
