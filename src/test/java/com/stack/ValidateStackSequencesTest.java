package com.stack;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ValidateStackSequencesTest {
    private final static String FILE_NAME = "validate_stack_sequences.csv";

    ValidateStackSequences vss = new ValidateStackSequences();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testValidateStackSequences(int[] pushed, int[] popped, boolean expected) {
        assertThat(vss.validateStackSequences(pushed, popped), is(expected));
    }


    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILE_NAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntArray(record.get(0)),
                        TestUtils.convertToIntArray(record.get(1)), Boolean.valueOf(record.get(2).replace(" ", ""))));
    }
}
