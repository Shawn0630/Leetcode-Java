package com.interviews.dropbox.text_editor;

public class Operation {
    String parm1;
    String parm2;


    TYPE type;

    public Operation(TYPE op, String parm1) {
        this.type = op;
        this.parm1 = parm1;
    }

    public Operation(TYPE op, String parm1, String parm2) {
        this.type = op;
        this.parm1 = parm1;
        this.parm2 = parm2;
    }

    public Operation(TYPE op) {
        this.type = op;
    }

    enum TYPE {
        APPEND,
        MOVE,
        DELETE,
        SELECT,
        CUT,
        PASTE,
        UNDO,
        REDO,
        CREATE,
        SWITCH;
    }
}
