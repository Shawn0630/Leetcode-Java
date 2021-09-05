package com.dynamic_programming;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JumpGameVITest {
    private final static String FILENAME = "jump_game_VI.csv";

    JumpGameVI jg4 = new JumpGameVI();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testJumpGame(int[] arr, int k, int output) {
        assertThat(jg4.maxResult(arr, k), is(output));
    }


    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToIntArray(csvRecord.get(0).replace(" ", "")),
                        Integer.valueOf(csvRecord.get(1).replace(" ", "")),
                        Integer.valueOf(csvRecord.get(2).replace(" ", ""))));
    }
}
