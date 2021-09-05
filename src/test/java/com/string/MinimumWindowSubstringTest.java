package com.string;

import com.TestUtils;
import com.strings.MinimumWindowSubstring;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MinimumWindowSubstringTest {
    private final static String FILENAME = "minimum_window_substring.csv";

    MinimumWindowSubstring mws = new MinimumWindowSubstring();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testSimplifyString(String input, String pattern, String output) {
        assertThat(mws.minWindow(input, pattern), is(output));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(csvRecord.get(0).replace(" ", ""),
                        csvRecord.get(1).replace(" ", ""),
                        csvRecord.get(2).replace(" ", "")));
    }

}
