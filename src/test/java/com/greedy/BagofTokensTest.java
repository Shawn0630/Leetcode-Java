package com.greedy;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BagofTokensTest {

    BagofTokens bot = new BagofTokens();

    private static final String FILE_NAME = "bags_of_tokens.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    public void testBagOfTokens(int[] tokens, int p, int score) {
        assertThat(bot.bagOfTokensScore(tokens, p), is(score));
    }


    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILE_NAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntArray(record.get(0)),
                        Integer.valueOf(record.get(1).replace(" ", "")),
                        Integer.valueOf(record.get(2).replace(" ", ""))));
    }
}
