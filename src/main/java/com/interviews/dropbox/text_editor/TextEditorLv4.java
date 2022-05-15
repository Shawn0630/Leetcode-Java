package com.interviews.dropbox.text_editor;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TextEditorLv4 {
    /*
    * Level 4
The text editor should support multiple text documents with a common clipboard.

9. CREATE <name> should create a blank text document name. If such a file already exists, ignore the operation and return empty string. Modification history is stored individually for each document.
10. SWITCH <name> should switch the current document to name. If there is no such file, ignore the operation and return empty string. When switching to a file, the position of the cursor and selection should return to the state in which they were left.

Note: it is guaranteed that all operations from previous levels will be executed on the active document. For backward compatibility, assume for Levels 1-3 there is a single, initially active document.

For example,

queries = [
    ["CREATE", "document1"],         | creates document1
    ["CREATE", "document2"],         | creates document2
    ["CREATE", "document1"],         | raises a runtime exception
    ["SWITCH", "document1"],         | switches to document1
    ["APPEND", "Hello, world!"],     | document1: "" -> "Hello, world!"
    ["SELECT", "7", "12"],           | selects "world"
    ["CUT"],                         | cuts "world" to the clipboard
    ["SWITCH", "document2"],         | switches to document2
    ["PASTE"],                       | document2: "" -> "world"
    ["SWITCH", "document1"],         | switches to document1
    ["DELETE"]                       | document1: "Hello, !" -> "Hello,!"
]

// returns: [ "",
              "",
              "",
              "",
              "Hello, world!",
              "Hello, world!",
              "Hello, !",
              "",
              "world",
              "Hello, !",
              "Hello,!" ]
Example

For

queries = [
    ["APPEND", "Hey"],
    ["APPEND", " you"],
    ["APPEND", ", don't"],
    ["APPEND", " "],
    ["APPEND", "let me down"]
]
the output should be

solution(queries) = [
    "Hey",
    "Hey you",
    "Hey you, don't",
    "Hey you, don't ",
    "Hey you, don't let me down"
]
Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.string queries

An array of operations need to be applied to the text editor. It is guaranteed that each operation is one of the operations described in the description, all operation parameters are given in correct format, and the text editor will never be in an incorrect state that is not described in the description.

Guaranteed constraints:
1 ≤ queries.length ≤ 250.

[output] array.string

After every operation, add the current state of the text to the resulting array. The returning array should consist of all the states after each operation is applied and have the same length as the # of input queries.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}
    * */

    Map<String, TextEditorLv3> textEditors;
    TextEditorLv3 currentEditor;
    public TextEditorLv4() {
        textEditors = new HashMap<>();
        currentEditor = null;
    }

    public String create(String name) {
        if (!textEditors.containsKey(name)) {
            textEditors.put(name, new TextEditorLv3());
        }

        return "";
    }

    public String switchTo(String name) {
        if (textEditors.containsKey(name)) {
            currentEditor = textEditors.get(name);
        }

        return "";
    }

    public String append(String in) {
        if (currentEditor != null) {
            return currentEditor.append(in);
        }

        return "";
    }

    public String select(int start, int end) {
        if (currentEditor != null) {
            return currentEditor.select(start, end);
        }

        return "";
    }

    public String cut() {
        if (currentEditor != null) {
            return currentEditor.cut();
        }

        return "";
    }

    public String move(int index) {
        if (currentEditor != null) {
            return currentEditor.move(index);
        }

        return "";
    }

    public String paste() {
        if (currentEditor != null) {
            return currentEditor.paste();
        }

        return "";
    }

    public String delete() {
        if (currentEditor != null) {
            return currentEditor.delete();
        }

        return "";
    }

    public String undo() {
        if (currentEditor != null) {
            return currentEditor.undo();
        }

        return "";
    }

    public String redo() {
        if (currentEditor != null) {
            return currentEditor.redo();
        }

        return "";
    }


    public class TextEditorLv3 {
        PasteBoard pasteBoard;
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
            pasteBoard = PasteBoard.getInstance();
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
                pasteBoard.pasteBoard = sb.subSequence(this.selectedStart, this.selectedEnd).toString();
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
            if (this.pasteBoard != null && this.pasteBoard.pasteBoard.length() > 0) {
                redo.clear();
                undo.push(copyHistory());
                if (selected) {
                    cutHelper();
                }
                sb.insert(cursor, this.pasteBoard.pasteBoard);
                this.selected = false;

            }

            return sb.toString();
        }

        public String delete() {
            if (selected) {
                redo.clear();
                undo.push(copyHistory());
                cutHelper();
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


    private static class PasteBoard {
        private static PasteBoard singleton = null;
        String pasteBoard;
        private PasteBoard() {
            pasteBoard = "";
        }

        public static PasteBoard getInstance() {
            if (singleton == null) {
                singleton = new PasteBoard();
            }
            return singleton;
        }
    }

}
