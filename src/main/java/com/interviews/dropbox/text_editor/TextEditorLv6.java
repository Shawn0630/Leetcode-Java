package com.interviews.dropbox.text_editor;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class TextEditorLv6 {


    static String[] solution(String[][] queries) {
        PasteBoard.clear();
        TextEditorManager textEditorManager = new TextEditorManager();
        String[] ans = new String[queries.length];
        int idx = 0;
        for (String[] query : queries) {
            String op = query[0];

            switch (op) {
                case "APPEND":
                    String text = query[1];
                    ans[idx++] = textEditorManager.getActiveTextEditor().append(text);
                    break;
                case "MOVE":
                    int index = Integer.parseInt(query[1]);
                    ans[idx++] = textEditorManager.getActiveTextEditor().move(index);
                    break;
                case "FORWARD_DELETE":
                    ans[idx++] = textEditorManager.getActiveTextEditor().forward_delete();
                    break;
                case "SELECT":
                    int start = Integer.parseInt(query[1]);
                    int end = Integer.parseInt(query[2]);
                    ans[idx++] = textEditorManager.getActiveTextEditor().select(start, end);
                    break;
                case "COPY":
                    ans[idx++] = textEditorManager.getActiveTextEditor().copy();
                    break;
                case "PASTE":
                    ans[idx++] = textEditorManager.getActiveTextEditor().paste();
                    break;
                case "UNDO":
                    ans[idx++] = textEditorManager.getActiveTextEditor().undo();
                    break;
                case "REDO":
                    ans[idx++] = textEditorManager.getActiveTextEditor().redo();
                    break;
                case "OPEN":
                    String name = query[1];
                    ans[idx++] = textEditorManager.open(name);
                    break;
                case "CLOSE":
                    ans[idx++] = textEditorManager.close();
                    break;
            }
        }
        return ans;
    }

    private static class TextEditorManager {


        TextEditor activeTextEditor;
        Map<String, TextEditor> editors;
        Deque<String> activeHistory;

        public TextEditorManager() {
            activeTextEditor = new TextEditor();
            editors = new HashMap<>();
            activeHistory = new LinkedList<>();
        }

        // open a docuement and make it active
        // create new document if not exists, return ""
        // return text with cursor at the end if document exists
        public String open(String name) {
            editors.putIfAbsent(name, new TextEditor());
            activeTextEditor = editors.get(name);

            activeHistory.remove(name);
            activeHistory.offerFirst(name);

            return activeTextEditor.initialize();
        }

        public String close() {
            if (!activeHistory.isEmpty()) {
                activeHistory.pollFirst();
                if (!activeHistory.isEmpty()) {
                    activeTextEditor = editors.get(activeHistory.peekFirst());
                    return activeTextEditor.getText();
                } else {
                    return "";
                }
            }

            return "";
        }

        public TextEditor getActiveTextEditor() {
            return this.activeTextEditor;
        }
    }

    private static class TextEditor {
        PasteBoard pasteBoard;
        Selection selection;
        int cursor;
        StringBuilder sb;
        Stack<History> undos;
        Stack<History> redos;

        public TextEditor() {
            pasteBoard = PasteBoard.getInstance();
            selection = null;
            cursor = 0;
            sb = new StringBuilder();
            undos = new Stack<>();
            redos = new Stack<>();
        }

        public String initialize() {
            selection = null;
            cursor = sb.length();
            undos.clear();
            redos.clear();

            return sb.toString();
        }

        public String getText() {
            return sb.toString();
        }


        // append the inputted string text
        // cursor should be at the end of the added string
        public String append(String text) {
            this.redos.clear();
            this.undos.push(History.copy(this));

            if (selection != null) {
                this.backward_delete();

                selection = null;

                this.append(text);
            } else {
                sb.insert(cursor, text);

                cursor += text.length();
            }

            return sb.toString();
        }

        // move the cursor to the specific position
        // 0-indexing
        // move the cursor to the nearest available position if overflow
        public String move(int index) {
            if (index < 0) {
                cursor = sb.length();
                return sb.toString();
            }
            this.selection = null;

            cursor = Math.min(index, sb.length());

            return sb.toString();
        }

        // remove the character right after the cursor, if any
        public String forward_delete() {
            if (selection != null) {
                this.redos.clear();
                this.undos.push(History.copy(this));
                this.backward_delete();
            } else {
                if (cursor < sb.length()) {
                    this.redos.clear();
                    this.undos.push(History.copy(this));
                    sb.deleteCharAt(cursor);
                }
            }

            return sb.toString();
        }

        public String backward_delete() {
            if (selection != null) {
                sb.delete(selection.start, selection.end);

                cursor = selection.start;
                selection = null;
            } else {
                if (cursor != 0) {
                    sb.deleteCharAt(cursor - 1);

                    cursor = cursor + 1;
                }
            }

            return sb.toString();
        }

        // select the text between left and right cursor
        // selection is empty, becomes a cursor
        // any moditifcation will places the cursor at the end of the modified segment
        // select + append, replace the selected characters with appended characters
        // select + forward_delete, deleted the selected characters
        // select + move, deslectes if any and moves the cursor
        public String select(int start, int end) {
            this.selection = null;

            if (start >= end) {
                return sb.toString();
            }
            if (start < 0 || start > sb.length()) {
                return sb.toString();
            }
            this.selection = new Selection(start, Math.min(end, sb.length()));

            return sb.toString();
        }

        // copy the selected text to clipboard
        // remain current selected text if no selected text
        public String copy() {
            if (selection != null) {
                pasteBoard.pasteBoard = sb.subSequence(selection.start, selection.end).toString();
            }

            return sb.toString();
        }

        // type the text from clipboard
        // current selected text is overwritten
        // cursor is placed at the end of the pasted text
        public String paste() {
            if (this.pasteBoard != null && this.pasteBoard.pasteBoard.length() > 0) {
                redos.clear();
                undos.push(History.copy(this));
                if (selection != null) {
                    backward_delete();
                }
                sb.insert(cursor, this.pasteBoard.pasteBoard);
                cursor += this.pasteBoard.pasteBoard.length();
                selection = null;

            }

            return sb.toString();
        }

        // restore the document to the sate beforethe previous modification or REDO
        // selection and cursor should be restored
        public String undo() {
            if (!undos.isEmpty()) {
                History history = undos.pop();
                this.redos.push(History.copy(this));
                pasteHistory(history);
            }

            return sb.toString();
        }


        // can only be performed if the document has not been modified since the lasts UNDO
        // restores the state including selection and the cursor
        public String redo() {
            this.undos.push(History.copy(this));
            if (!redos.isEmpty()) {
                History history = redos.pop();
                this.undos.push(History.copy(this));
                pasteHistory(history);
            }

            return sb.toString();
        }

        private void pasteHistory(History history) {
            this.sb = new StringBuilder(history.cur);
            this.cursor = history.cursor;
            this.selection = history.selection;
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

        public static PasteBoard clear() {
            singleton = new PasteBoard();

            return singleton;
        }
    }

    private static class Selection {
        int start, end;

        public Selection(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class History {
        String cur;
        int cursor;
        Selection selection;

        public History(String cur, int cursor, Selection selection) {
            this.cur = cur;
            this.cursor = cursor;
            this.selection = selection;
        }

        public static History copy(TextEditor textEditor) {
            return new History(textEditor.sb.toString(), textEditor.cursor, textEditor.selection);
        }
    }

    public static void main(String[] args) {
        String[][] queries = new String[][]{};

        String[] ans = solution(queries);

        return;
    }
}