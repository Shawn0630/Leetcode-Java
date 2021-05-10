package com.stack;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrappingRainWaterTest {
    private final static String FILE_NAME = "trapping_rain_water_tests.csv";

    TrappingRainWater trw = new TrappingRainWater();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testTrappingRainWater(int[] height, int result) {
        assertThat(trw.trap(height), is(result));
    }


    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILE_NAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntArray(record.get(0)),
                        Integer.valueOf(record.get(1).replace(" ", ""))));
    }
}
