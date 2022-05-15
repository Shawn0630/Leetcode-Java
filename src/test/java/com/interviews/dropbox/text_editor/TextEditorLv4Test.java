package com.interviews.dropbox.text_editor;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TextEditorLv4Test {
    static String FILENAME = "text_editor_lv4.txt";
    TextEditorTestHelpers textEditorTestHelpers = new TextEditorTestHelpers();
    @ParameterizedTest
    @MethodSource("generateData")
    public void testEditor(List<Action> actions) {
        TextEditorLv4 textEditorLv4 = new TextEditorLv4();
        for(Action action : actions) {
            assertEquals(action.expected, textEditorTestHelpers.execute(textEditorLv4, action));
        }
    }

    static Stream<Arguments> generateData() throws IOException {
        TextEditorTestHelpers textEditorTestHelpers = new TextEditorTestHelpers();
        return TestUtils.fetchTestCases(FILENAME).stream()
                .map(record -> Arguments.of(textEditorTestHelpers.buildActions(record)));
    }
}
