package com.interviews.dropbox.text_editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TextEditorLv5 {

    StringBuilder sb;
    int cursor;
    Selection selection;
    Stack<History> undos;
    Stack<History> redos;
    List<Node> list;
    String pastboard;

    public TextEditorLv5() {
        sb = new StringBuilder();
        list = new LinkedList<>();
        pastboard = null;
        cursor = 0;
        selection = null;
        undos = new Stack<>();
        redos = new Stack<>();
    }

    private String append(String str) {
        this.redos.clear();
        this.undos.push(History.copy(this));

        if (selection != null) {
            this.backspace();

            selection = null;

            this.append(str);
        } else {
            sb.append(str);
            list.addAll(buildNodes(str));

            cursor += str.length();
        }

        //return sb.toString();
        return printList();
    }

    // remove the last character of the current text
    // do nothing if there is no character left.
    // a[bc]d selection 1 -> 3, cursor => 1
    private String backspace() {
        this.redos.clear();
        this.undos.push(History.copy(this));

        if (selection != null) {
            sb.delete(selection.start, selection.end);
            list.subList(selection.start, selection.end).clear();

            cursor = selection.start;
            selection = null;
        } else {
            if (cursor != 0) {
                sb.deleteCharAt(cursor - 1);
                list.remove(cursor - 1);

                cursor = cursor - 1;
            }
        }

        //return sb.toString();
        return printList();
    }


    // undo an append or backspace operation
    // do nothing if more undos than append and backspace.
    private String undo() {
        if (!undos.isEmpty()) {
            History history = undos.pop();
            this.redos.push(History.copy(this));
            pasteHistory(history);
        }

        //return sb.toString();
        return printList();
    }

    // redo the previous undo operation
    // do nothing when more redos then undos
    // should only work immediately after an undo or redo operation.
    private String redo() {
        this.undos.push(History.copy(this));
        if (!redos.isEmpty()) {
            History history = redos.pop();
            this.undos.push(History.copy(this));
            pasteHistory(history);
        }

        //return sb.toString();
        return printList();
    }

    // performs the operation following it on the range from [start, end)
    // 1. selection is greater than the length of the current text, select up to the end
    // 2. select is followed by another select, the most recent to use
    // 3. the start is outside the range of the current text, ignore
    private String select(int start, int end) {
        this.selection = null;

        if (start >= end) {
            //return sb.toString();
            return printList();
        }
        if (start < 0 || start > sb.length()) {
            //return sb.toString();
            return printList();
        }
        this.selection = new Selection(start, Math.min(end, sb.length()));

        //return sb.toString();
        return printList();
    }

    // a bc d  select [1, 3)
    // bold should append * before the first selected character, and after the last selected character
    // when characters is selected
    private String bold() {
        if (selection != null) {
            list.get(selection.start).setBold();
            list.get(selection.end).setBold();

        }

        //return sb.toString();
        return printList();
    }

    private String copy() {
        if (selection != null) {
            pastboard = subList(selection.start, selection.end);
        }

        return printList();
    }

    private String cut() {
        if (selection != null) {
            redos.clear();
            undos.push(History.copy(this));

            copy();
            backspace();
            selection = null;
        }

        return printList();
    }

    private List<Node> buildNodes(String str) {
        List<Node> nodes = new ArrayList<>();

        for(char c : str.toCharArray()) {
            nodes.add(new Node(c));
        }

        return nodes;
    }

    private class Node {
        char c;
        boolean isBold;

        public Node(char c) {
            this.c = c;
            isBold = false;
        }

        public void setBold() {
            this.isBold = true;
        }

        public boolean isBold() {
            return this.isBold;
        }
    }

    private String printList() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Node node : this.list) {
            if (node.isBold()) {
                stringBuilder.append("*");
            }
            stringBuilder.append(node.c);
        }

        return stringBuilder.toString();
    }

    private String subList(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Node node : this.list.subList(start, end)) {
            stringBuilder.append(node.c);
        }

        return stringBuilder.toString();
    }

    private void pasteHistory(History history) {
        this.sb = new StringBuilder(history.cur);
        this.list = history.list;
        this.cursor = history.cursor;
        this.selection = history.selection;
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
        List<Node> list;
        int cursor;
        Selection selection;

        public History(String cur, List<Node> list, int cursor, Selection selection) {
            this.cur = cur;
            this.list = list;
            this.cursor = cursor;
            this.selection = selection;
        }

        public static History copy(TextEditorLv5 textEditorLv5) {
            return new History(textEditorLv5.sb.toString(), new LinkedList<>(textEditorLv5.list), textEditorLv5.cursor, textEditorLv5.selection);
        }
    }

    public String performOperations(String[][] operations) {
        Arrays.sort(operations, (a, b) -> a[0].compareTo(b[0]));

        for(String[] operation : operations) {
            String op = operation[1];

            switch (op) {
                case "APPEND":
                    this.append(operation[2]);
                    break;
                case "BACKSPACE":
                    this.backspace();
                    break;
                case "SELECT":
                    int start = Integer.parseInt(operation[2]);
                    int end = Integer.parseInt(operation[3]);
                    this.select(start, end);
                    break;
                case "CUT":
                    this.cut();
                    break;
                case "COPY":
                    this.copy();
                case "BOLD":
                    this.bold();
                    break;
                case "UNDO":
                    this.undo();
                    break;
                case "REDO":
                    this.redo();
                    break;
            }
        }

        return printList();
    }
}
