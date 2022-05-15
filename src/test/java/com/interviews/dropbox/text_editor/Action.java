package com.interviews.dropbox.text_editor;

public class Action {
    Operation op;
    String expected;
    public Action(Operation op, String expectedResult) {
        this.op = op;
        this.expected = expectedResult;
    }
}
