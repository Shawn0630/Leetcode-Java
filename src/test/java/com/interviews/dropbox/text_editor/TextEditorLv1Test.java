package com.interviews.dropbox.text_editor;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextEditorLv1Test {

    static String FILENAME = "text_editor_lv1.txt";
    TextEditorTestHelpers textEditorTestHelpers = new TextEditorTestHelpers();
    @ParameterizedTest
    @MethodSource("generateData")
    public void testEditor(List<Action> actions) {
        TextEditorLv1 textEditorLv1 = new TextEditorLv1();
        for(Action action : actions) {
            assertEquals(action.expected, textEditorTestHelpers.execute(textEditorLv1, action));
        }
    }

    static Stream<Arguments> generateData() throws IOException {
        TextEditorTestHelpers textEditorTestHelpers = new TextEditorTestHelpers();
        return TestUtils.fetchTestCases(FILENAME).stream()
                .map(record -> Arguments.of(textEditorTestHelpers.buildActions(record)));
    }

}
