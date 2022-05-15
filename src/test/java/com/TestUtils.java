package com;

import com.linked_list.ListNode;
import com.tree.TreeNode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class TestUtils {

    public static int[] convertToIntArray(String input) {
        return convertToIntArray(input, ";");
    }

    public static int[] convertToIntArray(String input, String delimiter) {
        String tmp = input.replace(" ", "");
        tmp = tmp.substring(1, tmp.length() - 1);
        if (tmp.replace(" ", "").length() == 0) {
            return new int[]{};
        }
        return Arrays.stream(tmp.split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static ListNode convertToList(String input) {
        int[] array = convertToIntArray(input, "->");

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for(int i : array) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }

        return dummy.next;
    }

    public static TreeNode convertToBinaryTree(String input) {
        String[] array = convertToStringArray(input);
        if (array.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean curLeft = true;
        TreeNode curParent = null;
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        queue.add(root);

        for(int i = 1; i < array.length; i++) {
            if (!array[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(array[i]));
                if(curLeft) {
                    curParent = queue.poll();
                    curParent.left = node;
                } else {
                    if (curParent != null) {
                        curParent.right = node;
                    }
                }

                queue.add(node);
            } else {
                if(curLeft) {
                    curParent = queue.poll();
                }
            }
            curLeft = !curLeft;
        }

        return root;
    }

    public static char[] convertToCharArray(String input) {
        String tmp = input.replace(" ", "");
        tmp = tmp.substring(1, tmp.length() - 1);
        String[] strings = tmp.split(";");
        StringBuilder output = new StringBuilder();
        for(String s : strings) {
            output.append(s);
        }
        return output.toString().toCharArray();
    }

    public static String[] convertToStringArray(String input, String delimiter) {
        String tmp = input.replace(" ", "");
        tmp = tmp.substring(1, tmp.length() - 1);

        if (tmp.replace(" ", "").length() == 0) {
            return new String[]{};
        }

        return tmp.split(delimiter);
    }

    public static String[] convertToStringArray(String input) {
        return convertToStringArray(input, ";");
    }

    public static List<Integer> convertToIntegerList(String input) {
        String tmp = input.replace(" ", "");
        tmp = tmp.substring(1, tmp.length() - 1);
        String[] integers = tmp.split(";");
        return Arrays.stream(integers).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static List<CSVRecord> fetchCSVRecord(String file) throws IOException {
        final InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(file);
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        final CSVParser csvParser = new CSVParser(inputStreamReader, CSVFormat.EXCEL.withFirstRecordAsHeader());
        return csvParser.getRecords();
    }

    public static List<String> fetchTestCases(String file) {
        final InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().collect(Collectors.toList());
    }
}
