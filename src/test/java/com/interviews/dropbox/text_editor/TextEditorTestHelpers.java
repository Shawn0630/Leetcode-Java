package com.interviews.dropbox.text_editor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditorTestHelpers {
    private static String BLANKET_REGEX = "\\[[^\\[]*\\]";
    private static String QUOTATION_REGEX = "\\\"[^\\\"]*\\\"";

    public String execute(TextEditorLv1 textEditorLv1, Action action) {
        Operation operation = action.op;

        switch (operation.type) {
            case APPEND:
                return textEditorLv1.append((String) operation.parm1);
            case MOVE:
                return textEditorLv1.move(Integer.parseInt(operation.parm1.replace(" ", "")));
            case DELETE:
                return textEditorLv1.delete();
        }

        return "";
    }

    public String execute(TextEditorLv2 textEditorLv2, Action action) {
        Operation operation = action.op;

        switch (operation.type) {
            case APPEND:
                return textEditorLv2.append((String) operation.parm1);
            case MOVE:
                return textEditorLv2.move(Integer.parseInt(operation.parm1.replace(" ", "")));
            case DELETE:
                return textEditorLv2.delete();
            case SELECT:
                return textEditorLv2.select(Integer.parseInt(operation.parm1.replace(" ", "")),
                                            Integer.parseInt(operation.parm2.replace(" ", "")));
            case PASTE:
                return textEditorLv2.paste();
            case CUT:
                return textEditorLv2.cut();
        }

        return "";
    }

    public String execute(TextEditorLv3 textEditorLv3, Action action) {
        Operation operation = action.op;

        switch (operation.type) {
            case APPEND:
                return textEditorLv3.append((String) operation.parm1);
            case MOVE:
                return textEditorLv3.move(Integer.parseInt(operation.parm1.replace(" ", "")));
            case DELETE:
                return textEditorLv3.delete();
            case SELECT:
                return textEditorLv3.select(Integer.parseInt(operation.parm1.replace(" ", "")),
                        Integer.parseInt(operation.parm2.replace(" ", "")));
            case PASTE:
                return textEditorLv3.paste();
            case CUT:
                return textEditorLv3.cut();
            case UNDO:
                return textEditorLv3.undo();
            case REDO:
                return textEditorLv3.redo();

        }

        return "";
    }

    public String execute(TextEditorLv4 textEditorLv4, Action action) {
        Operation operation = action.op;

        switch (operation.type) {
            case APPEND:
                return textEditorLv4.append((String) operation.parm1);
            case MOVE:
                return textEditorLv4.move(Integer.parseInt(operation.parm1.replace(" ", "")));
            case DELETE:
                return textEditorLv4.delete();
            case SELECT:
                return textEditorLv4.select(Integer.parseInt(operation.parm1.replace(" ", "")),
                        Integer.parseInt(operation.parm2.replace(" ", "")));
            case PASTE:
                return textEditorLv4.paste();
            case CUT:
                return textEditorLv4.cut();
            case UNDO:
                return textEditorLv4.undo();
            case REDO:
                return textEditorLv4.redo();
            case CREATE:
                return textEditorLv4.create(operation.parm1);
            case SWITCH:
                return textEditorLv4.switchTo(operation.parm1);

        }

        return "";
    }

    public String[][] buildInputCommands(String input) {
        Pattern p = Pattern.compile(BLANKET_REGEX); // https://regex101.com
        Matcher m = p.matcher(input);
        List<String[]> operations = new ArrayList<>();
        while (m.find()) {
            String action = m.group();
            action = action.replace("[", "")
                    .replace("]", "");
            Pattern statementPattern = Pattern.compile(QUOTATION_REGEX);
            Matcher statementMatcher = statementPattern.matcher(action);
            List<String> statements = new ArrayList<>();
            while (statementMatcher.find()) {
                statements.add(statementMatcher.group().replace("\"", ""));
            }
            operations.add(statements.toArray(new String[]{}));
        }

        return operations.toArray(new String[][]{});
    }

    public List<Action> buildActions(String input) {
        Pattern p = Pattern.compile(BLANKET_REGEX); // https://regex101.com
        Matcher m = p.matcher(input);
        List<Action> actions = new ArrayList<>();
        while (m.find()) {
            String action = m.group();
            action = action.replace("[", "").replace("]", "");
            Pattern actionPattern = Pattern.compile(QUOTATION_REGEX);
            Matcher actionMatcher = actionPattern.matcher(action);
            List<String> statements = new ArrayList<>();
            while (actionMatcher.find()) {
                statements.add(actionMatcher.group().replace("\"", ""));
            }
            String operation = statements.get(0);

            switch (operation) {
                case "APPEND":
                    actions.add(new Action(new Operation(Operation.TYPE.APPEND, statements.get(1)), statements.get(2)));
                    break;
                case "MOVE":
                    actions.add(new Action(new Operation(Operation.TYPE.MOVE, statements.get(1)), statements.get(2)));
                    break;
                case "DELETE":
                    actions.add(new Action(new Operation(Operation.TYPE.DELETE), statements.get(1)));
                    break;
                case "SELECT":
                    actions.add(new Action(new Operation(Operation.TYPE.SELECT, statements.get(1), statements.get(2)), statements.get(3)));
                    break;
                case "CUT":
                    actions.add(new Action(new Operation(Operation.TYPE.CUT), statements.get(1)));
                    break;
                case "PASTE":
                    actions.add(new Action(new Operation(Operation.TYPE.PASTE), statements.get(1)));
                    break;
                case "UNDO":
                    actions.add(new Action(new Operation(Operation.TYPE.UNDO), statements.get(1)));
                    break;
                case "REDO":
                    actions.add(new Action(new Operation(Operation.TYPE.REDO), statements.get(1)));
                    break;
                case "CREATE":
                    actions.add(new Action(new Operation(Operation.TYPE.CREATE, statements.get(1)), statements.get(2)));
                case "SWITCH":
                    actions.add(new Action(new Operation(Operation.TYPE.SWITCH, statements.get(1)), statements.get(2)));
            }
        }

        return actions;
    }
}
