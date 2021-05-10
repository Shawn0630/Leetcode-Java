package com.bitoperation;


import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class RepeatedDNASequencesTests {

    RepeatedDNASequences dnaSequences = new RepeatedDNASequences();
    private static String FILENAME = "repeated_DNA_sequences.csv";

    @ParameterizedTest
    @MethodSource("generateData")
    public void testRepeatedDNASequences(String dna, String[] expected) {
        assertThat(dnaSequences.findRepeatedDnaSequences(dna), containsInAnyOrder(expected));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(record.get(0).replace(" ", ""),
                        TestUtils.convertToStringArray(record.get(1).replace(" ", ""))));
    }

}
