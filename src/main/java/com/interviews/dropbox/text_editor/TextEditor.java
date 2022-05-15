package com.interviews.dropbox.text_editor;

import java.util.Stack;

public class TextEditor {
    // https://leetcode.com/discuss/interview-question/860501/Text-Editor-Implementation
    StringBuilder sb;
    enum Operations {
        INSERT, DELETE, COPY, PASTE, UNDO
    }
    Stack<History> histories;
    String clipBoard;
    int cursor;

    public TextEditor() {
        sb = new StringBuilder();
        histories = new Stack<>();
        clipBoard = "";
        cursor = 0;
    }

    public String insert(String in) {
        sb.append(in);
        cursor += in.length() - 1;
        histories.push(new History(Operations.INSERT, in));

        return sb.toString();
    }

    public String move(int index) {
        cursor = index;

        return sb.toString();
    }

    // 0    1   2   3
    // a    b   c|  d

    public String delete() {
        if (sb.length() == 0) {
            return "";
        } else {
            histories.push(new History(Operations.DELETE, String.valueOf(sb.charAt(sb.length() - 1))));
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    public String copy(int start) {
        if (start < 0 || start >= sb.length()) {
            return "";
        }

        clipBoard = sb.substring(start);
        return clipBoard;
    }

    public String paste() {
        if (!clipBoard.equals("")) {
            sb.append(clipBoard);
            histories.push(new History(Operations.PASTE, clipBoard));
        }

        return sb.toString();
    }

    public String undo() {
        if (!histories.empty()) {
            History history = histories.pop();

            switch (history.op) {
                case INSERT:
                case PASTE:
                    String content = history.content;
                    // 0    1   2
                    // a    b   c   bc
                    //
                    sb.delete(sb.length() - content.length(), sb.length());
                    break;
                case DELETE:
                    sb.append(history.content);
                    break;
            }

            return sb.toString();
        }

        return sb.toString();
    }

    private class History {
        Operations op;
        String content;

        public History(Operations op, String content) {
            this.op = op;
            this.content = content;
        }

        public History(Operations op) {
            this.op = op;
            content = "";
        }
    }


    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        // "INSERT Code", "INSERT Signal", "DELETE", "UNDO"
        textEditor.insert("Code");
        textEditor.insert("Signal");
        textEditor.delete();
        System.out.println(textEditor.undo());

        // "INSERT Da", "COPY 0", "UNDO", "PASTE", "PASTE", "COPY 2", "PASTE", "PASTE", "DELETE", "INSERT aaam"

        textEditor = new TextEditor();
        textEditor.insert("Da");
        textEditor.copy(0);
        textEditor.undo();
        textEditor.paste();
        textEditor.paste();
        textEditor.copy(2);
        textEditor.paste();
        textEditor.paste();
        textEditor.delete();
        System.out.println(textEditor.insert("aaam"));
    }
}
