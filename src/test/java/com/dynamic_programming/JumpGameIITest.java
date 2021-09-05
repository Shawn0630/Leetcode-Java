package com.dynamic_programming;

import com.TestUtils;
import com.strings.LongestRepeatingCharacterReplacement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JumpGameIITest {
    private final static String FILENAME = "jump_game_II.csv";

    JumpGameII jg2 = new JumpGameII();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testJumpGame(int[] input, int output) {
        assertThat(jg2.jump(input), is(output));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    public void testGreedyJumpGame(int[] input, int output) {
        assertThat(jg2.greedy_jump(input), is(output));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToIntArray(csvRecord.get(0).replace(" ", "")),
                        Integer.valueOf(csvRecord.get(1).replace(" ", ""))));
    }
}
