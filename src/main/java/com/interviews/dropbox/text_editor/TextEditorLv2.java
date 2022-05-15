package com.interviews.dropbox.text_editor;

public class TextEditorLv2 {
    /*
    * Level 2
Introduce methods to copy a part of the document text.

4. SELECT <left> <right> should select the text between the left and right cursor positions. Selection borders should be returned to the bounds of the document. If the selection is empty, it becomes a cursor position. Any modification operation replace the selected text and places the cursor at the end of the modified segment.

Additionally,

SELECT and APPEND should replace the selected characters with the appended characters
SELECT and DELETE should delete the selected characters
SELECT and MOVE deselects characters if there were any and moves the cursor
For example, the following operations

queries = [
    ["APPEND", "Hello cruel world!"],  | "" -> "Hello cruel world!"
    ["SELECT", "5", "11"],             | selects " cruel"
    ["APPEND", ","],                   | "Hello cruel world!" -> "Hello, world!"
    ["SELECT", "5", "12"],             | selects ", world"
    ["DELETE"],                        | "Hello, world!" -> "Hello!"
    ["SELECT", "4", "6"],              | selects "o!"
    ["MOVE", "1"]                      | moves cursor before "e", deselects "o!"
]

// returns: [ "Hello cruel world!",
//            "Hello cruel world!",
//            "Hello, world!",
//            "Hello, world!",
//            "Hello!",
//            "Hello!",
//            "Hello!" ]
produce "Hello!" with the cursor positioned after letter H.

5. CUT should remove the selected text and save it to the clipboard, if there is an active non-empty selection.
6. PASTE should append the text from the clipboard. The current selected text (if any) remains selected after the operation.

For example, the following operations

queries = [
    ["APPEND", "Hello, world!"],       | "" -> "Hello, world!" // before the nth element(0 indexing)
    ["SELECT", "5", "12"],             | selects ", world"
    ["CUT"],                           | "Hello, world!" -> "Hello!"
    ["MOVE", "4"],                     | moves the cursor between "l" and "o": "Hell|o!"
    ["PASTE"],                         | "Hello!" -> "Hell, worldo!"
    ["PASTE"]                          | "Hell, worldo!" -> "Hell, world, worldo!"
]

// returns: [ "Hello, world!",
//            "Hello, world!",
//            "Hello!",
//            "Hello!",
//            "Hell, worldo!",
//            "Hell, world, worldo!" ]
    * */

    // a    b   c
    //
    String pasteBoard;
    StringBuilder sb;
    int cursor;
    int selectedStart;
    int selectedEnd;
    boolean selected;
    public TextEditorLv2() {
        this.sb = new StringBuilder();
        selected = false;
        pasteBoard = "";
        cursor = 0;
    }

    public String append(String in) {
        if (selected) {
            this.cut();
        }
        sb.insert(cursor, in);
        cursor += in.length();

        return sb.toString();
    }

    public String select(int start, int end) {
        this.selectedStart = start;
        this.selectedEnd = end;
        this.selected = true;

        return sb.toString();
    }

    public String cut() {
        if (selected) {
            this.pasteBoard = sb.subSequence(this.selectedStart, this.selectedEnd).toString();
            sb.delete(this.selectedStart, this.selectedEnd);
            this.selected = false;
            this.cursor = selectedStart;
        }

        return sb.toString();
    }

    public String move(int index) {
        this.cursor = index;
        this.selected = false;

        return sb.toString();
    }

    public String paste() {
        if (selected) {
            this.cut();
        }
        sb.insert(cursor, this.pasteBoard);
        this.selected = false;

        return sb.toString();
    }

    public String delete() {
        if (selected) {
            this.cut();
        } else if (cursor != sb.length()){
            sb.deleteCharAt(cursor);
        }

        return sb.toString();
    }
}
