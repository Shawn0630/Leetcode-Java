package com.interviews.dropbox.text_editor;

import java.util.Stack;

public class TextEditorLv3 {
    /*
    * Level 3
The text editor should allow document changes to be tracked and reverted. Consider only operations that actually modify the contents of the text document.

7. UNDO should restore the document to the state before the previous modification or REDO operation. The selection and cursor position should be also restored.

For example,

queries = [
    ["APPEND", "Hello, world!"],       | "" -> "Hello, world!"
    ["SELECT", "7", "12"],             | selects "world"
    ["DELETE"],                        | "Hello, world!" -> "Hello, !"
    ["UNDO"],                          | restores "Hello, world!" with "world" selected
    ["APPEND", "you"]                  | "Hello, world!" -> "Hello, you!"
]

// returns: [ "Hello, world!",
              "Hello, world!",
              "Hello, !",
              "Hello, world!",
              "Hello, you!" ]
8. REDO can only be performed if the document has not been modified since the last UNDO operation. REDO should restore the state before the previous UNDO operation, including the selection and cursor position. Multiple UNDO and REDO operations can be performed in a row.

For example,

queries = [
    ["APPEND", "Hello, world!"],       | "" -> "Hello, world!"
    ["SELECT", "7", "12"],             | selects "world"
    ["DELETE"],                        | "Hello, world!" -> "Hello, !"
    ["MOVE", "6"],                     | moves the cursor after the comma
    ["UNDO"],                          | restores "Hello, world!" with "world" selected
    ["UNDO"],                          | restores initial ""
    ["REDO"],                          | restores "Hello, world!" with "world" selected
    ["REDO"]                           | restores "Hello, !" with the cursor after the comma
]

// returns: [ "Hello, world!",
              "Hello, world!",
              "Hello, !",
              "Hello, !",
              "Hello, world!",
              "",
              "Hello, world!",
              "Hello, !" ]
    * */

    String pasteBoard;
    StringBuilder sb;
    int cursor;
    int selectedStart;
    int selectedEnd;
    boolean selected;
    Stack<History> undo;
    Stack<History> redo;
    // abc => a => ab
    public TextEditorLv3() {
        this.sb = new StringBuilder();
        selected = false;
        pasteBoard = "";
        cursor = 0;
        undo = new Stack<>();
        redo = new Stack<>();
    }

    public String append(String in) {
        if (in != null && in.length() > 0) {
            redo.clear();
            undo.push(copyHistory());
            if (selected) {
                cutHelper();
            }
            sb.insert(cursor, in);
            cursor += in.length();

        }

        return sb.toString();
    }

    public String select(int start, int end) {
        if (start < end) {
            this.selectedStart = start;
            this.selectedEnd = end;
            this.selected = true;
        }

        return sb.toString();
    }

    public String cut() {
        if (selected) {
            redo.clear();
            undo.push(copyHistory());
            this.pasteBoard = sb.subSequence(this.selectedStart, this.selectedEnd).toString();
            cutHelper();

        }

        return sb.toString();
    }

    private void cutHelper() {
        sb.delete(this.selectedStart, this.selectedEnd);
        this.selected = false;
        this.cursor = selectedStart;
    }


    public String move(int index) {
        this.cursor = Math.min(index, sb.length());
        this.selected = false;

        return sb.toString();
    }

    public String paste() {
        if (this.pasteBoard != null && this.pasteBoard.length() > 0) {
            redo.clear();
            undo.push(copyHistory());
            if (selected) {
                cutHelper();
            }
            sb.insert(cursor, this.pasteBoard);
            this.selected = false;

        }

        return sb.toString();
    }

    public String delete() {
        if (selected) {
            redo.clear();
            undo.push(copyHistory());
            cutHelper();
            this.pasteBoard = "";
        } else if (cursor != 0){
            redo.clear();
            undo.push(copyHistory());
            sb.deleteCharAt(cursor - 1);
        }

        return sb.toString();
    }

    public String undo() {
        if (!undo.empty()) {
            History history = undo.pop();
            redo.push(copyHistory());
            pasteHistory(history);
        }

        return sb.toString();
    }

    public String redo() {
        if (!redo.empty()) {
            History history = redo.pop();
            undo.push(copyHistory());
            pasteHistory(history);
        }

        return sb.toString();
    }

    private void pasteHistory(History history) {
        sb = new StringBuilder(history.content);
        this.selected = history.selected;
        this.selectedStart = history.selectedStart;
        this.selectedEnd = history.selectedEnd;
        this.cursor = history.cursor;
    }

    private History copyHistory() {
        return new History(sb.toString(), this.cursor, this.selected, this.selectedStart, this.selectedEnd);
    }

    private class History {
        String content;
        int cursor;
        int selectedStart;
        int selectedEnd;
        boolean selected;

        public History(String content, int cursor, boolean selected, int selectedStart, int selectedEnd) {
            this.content = content;
            this.cursor = cursor;
            this.selected = selected;
            this.selectedStart = selectedStart;
            this.selectedEnd = selectedEnd;
        }
    }
}
