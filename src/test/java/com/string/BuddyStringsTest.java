package com.string;

import com.TestUtils;
import com.strings.BuddyStrings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BuddyStringsTest {
    private final static String FILENAME = "buddy_string_test_cases.csv";
    BuddyStrings bs = new BuddyStrings();

    @ParameterizedTest
    @MethodSource("generateData")
    void testBuddyStrings(String A, String B, boolean expected) {
        assertThat(bs.buddyStrings(A, B), is(expected));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(record.get(0).replace(" ", ""),
                        (record.get(1).replace(" ", "")),
                        Boolean.valueOf(record.get(2).replace(" ", ""))));
    }
}
