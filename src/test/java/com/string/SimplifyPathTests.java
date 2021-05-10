package com.string;

import com.TestUtils;
import com.strings.SimplifyPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimplifyPathTests {
    private final static String FILENAME = "simplify_path_test_cases.csv";

    private final SimplifyPath sp = new SimplifyPath();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testSimplifyString(String input, String expected) {
        assertThat(sp.simplifyPath(input), is(expected));
    }


    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(csvRecord.get(0).replace(" ", ""), csvRecord.get(1).replace(" ", "")));
    }
}
