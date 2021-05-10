package com.array;

import com.TestUtils;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShortestDistancetoaCharacterTest {
    ShortestDistancetoaCharacter sd = new ShortestDistancetoaCharacter();

    protected static String getTestFileName() {
        return "shortest_distance_to_a_character.csv";
    }

    protected static Function<CSVRecord, Arguments> csvRecordConverter() {
        return csvRecord -> Arguments.of(
                csvRecord.get(0).replace(" ", ""),
                csvRecord.get(1).replace(" ", "").toCharArray()[0],
                TestUtils.convertToIntArray(csvRecord.get(2).replace(" ", ""))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    public void testSimplifyString(String str, char c, int[] expected) {
        assertThat(sd.shortestToChar(str, c), is(expected));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(getTestFileName()).stream()
                .map(csvRecordConverter());
    }
}
