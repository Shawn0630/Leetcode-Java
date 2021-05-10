package com.search;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HIndexIITest {
    HIndexII hIndexII = new HIndexII();
    HIndex hindex = new HIndex();
    private static final String TEST_FILE = "h_index_iI_tests.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    public void test2(int[] citations, int hIndex) {
        assertThat(hIndexII.hIndex(citations), is(hIndex));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    public void test(int[] citations, int hIndex) {
        assertThat(hindex.hIndex(citations), is(hIndex));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(TEST_FILE).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToIntArray(csvRecord.get(0)),
                        Integer.valueOf(csvRecord.get(1).replace(" ", ""))));
    }
}
