package com.search;

import com.TestUtils;
import com.strings.RemoveDuplicateLetters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicateLettersTest {

    private static final String FILENAME = "remove_duplicate_letter_test_cases.csv";
    RemoveDuplicateLetters rd = new RemoveDuplicateLetters();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testRemoveDuplicateLetters(String input, String expected) {
        assertEquals(expected, rd.removeDuplicateLetters(input));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(record.get(0).replace(" ", ""), record.get(1).replace(" ", "")));
    }
}
