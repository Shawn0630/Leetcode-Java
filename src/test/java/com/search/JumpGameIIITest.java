package com.search;

import com.TestUtils;
import com.dynamic_programming.JumpGameII;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JumpGameIIITest {
    private final static String FILENAME = "jump_game_III.csv";

    JumpGameIII jg3 = new JumpGameIII();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testJumpGame(int[] array, int start, boolean output) {
        assertThat(jg3.canReach(array, start), is(output));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToIntArray(csvRecord.get(0).replace(" ", "")),
                        Integer.valueOf(csvRecord.get(1).replace(" ", "")),
                        Boolean.valueOf(csvRecord.get(2).replace(" ", ""))));
    }
}
