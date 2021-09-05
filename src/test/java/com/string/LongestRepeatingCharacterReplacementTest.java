package com.string;

import com.TestUtils;
import com.strings.LongestRepeatingCharacterReplacement;
import com.strings.MinimumWindowSubstring;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongestRepeatingCharacterReplacementTest {
    private final static String FILENAME = "longest_repeating_character_replacement.csv";

    LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testLongestRepeatingCharacterReplacement(String input, int k, int output) {
        assertThat(lrcr.characterReplacement(input, k), is(output));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(csvRecord.get(0).replace(" ", ""),
                        Integer.valueOf(csvRecord.get(1).replace(" ", "")),
                        Integer.valueOf(csvRecord.get(2).replace(" ", ""))));
    }
}
