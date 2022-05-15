package com.interviews.dropbox.text_editor;

public class TextEditorLv1 {


    // https://leetcode.com/discuss/interview-question/1631153/dropbox-oa-text-edtior

    /*
    * Your task is to implement a simplified version of text editor.

All operations that should be supported are listed below. Partial credit will be given for each implemented operation. Please submit often to ensure partial credits are captured.

Implementation tips

Implement operations and provided steps one by one, and not all together, keeping in mind that you will need to make refactors to support each additional step. In the first three levels you can assume that only one text document is modified.

Note

After every operation, add the current state of the text to the resulting array. The returning array should consist of all the states after each operation is applied and have the same length as the # of input queries.

Level 1
The editor starts with a blank text document, with the cursor at initial position 0.

1. APPEND <text> should append the inputted string text to the document starting from the current position of the cursor. After the operation, the cursor should be at the end of the added string.

queries = [
    ["APPEND", "Hey"],               | "" -> "Hey"
    ["APPEND", " there"],            | "Hey" -> "Hey there"
    ["APPEND", "!"]                  | "Hey there" -> "Hey there!"
]

// returns: [ "Hey",
//            "Hey there",
//            "Hey there!" ]
2. MOVE <position> should move the cursor to the specified position. The cursor should be positioned between document characters, and are enumerated sequentially starting from 0. If the specified position is out of bounds, then move the cursor to the nearest available position.

queries = [
    ["APPEND", "Hey you"],           | "" -> "Hey you"
    ["MOVE", "3"],                   | moves the cursor after the first "y"
    ["APPEND", ","]                  | "Hey you" -> "Hey, you"
]

// returns: [ "Hey, you",
//            "Hey you",
//            "Hey, you" ]
3. DELETE should remove the character right after the cursor, if any.

queries = [
    [APPEND", "Hello! world!"],      | "" -> "Hello! world!"
    ["MOVE", "5"],                   | moves the cursor before the first "!"
    ["DELETE"],                      | "Hello! world!" -> "Hello world!"
    ["APPEND", ","]                  | "Hello world!" -> "Hello, world!"
]

// returns: [ "Hello! world!",
//            "Hello! world!",
//            "Hello world!",
//            "Hello, world!" ]
and

queries = [
    ["APPEND", "!"],                 | "" -> "!"
    ["DELETE"],                      | "!" -> "!"
    ["MOVE", "0"],                   | moves the cursor before the first symbol
    ["DELETE"],                      | "!" -> ""
    ["DELETE"]                       | "" -> ""
]

// returns: [ "!",
//            "",
//            "",
//            "",
//            "" ]
    * */

    private int cursor;
    private StringBuilder sb;
    // 0    1   2   3   4   5   6   7   8   9   10  11
    // H    e   l   l   o   !   w   o   r   l   d   !
    //
    public TextEditorLv1() {
        sb = new StringBuilder();
        cursor = 0;
    }

    public String append(String in) {
        sb.insert(cursor, in);
        cursor += in.length();

        return sb.toString();
    }

    public String move(int index) {
        cursor = index;

        return sb.toString();
    }

    public String delete() {
        if(cursor == sb.length()) {
            return sb.toString();
        }
        sb.deleteCharAt(cursor);
        return sb.toString();
    }


    public static void main(String[] args) {
        TextEditorLv1 textEditorLv1 = new TextEditorLv1();
        textEditorLv1.append("Hello! world!");
        textEditorLv1.move(5);
        textEditorLv1.delete();
        System.out.println(textEditorLv1.append(","));
    }
}
