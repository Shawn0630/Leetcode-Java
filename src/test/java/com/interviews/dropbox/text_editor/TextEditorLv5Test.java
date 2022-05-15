package com.interviews.dropbox.text_editor;

import com.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TextEditorLv5Test {

    TextEditorLv5 textEditorLv5;

    @BeforeEach
    public void before() {
        textEditorLv5 = new TextEditorLv5();
    }

    static String FILENAME = "text_editor_lv5.txt";
    TextEditorTestHelpers textEditorTestHelpers = new TextEditorTestHelpers();
    @ParameterizedTest
    @MethodSource("generateData")
    public void testEditor(String[][] inputs, String expected) {
        TextEditorLv5 textEditorLv5 = new TextEditorLv5();
        assertEquals(expected, textEditorLv5.performOperations(inputs));
    }

    static Stream<Arguments> generateData() throws IOException {
        TextEditorTestHelpers textEditorTestHelpers = new TextEditorTestHelpers();
        return TestUtils.fetchTestCases(FILENAME).stream()
                .map(record -> {
                    String[][] inputs = textEditorTestHelpers.buildInputCommands(record);
                    String[][] operations = Arrays.copyOf(inputs, inputs.length - 1);
                    String expected = inputs[inputs.length - 1][0];
                    return Arguments.of(operations, expected);
                });
    }

    @Test
    public void test1() {
        String[][] input = new String[][] {
                {"0", "APPEND", "Hey you"},
                {"1", "BACKSPACE"}
        };

        assertEquals("Hey yo", textEditorLv5.performOperations(input));
    }
}
