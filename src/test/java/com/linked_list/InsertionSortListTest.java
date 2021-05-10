package com.linked_list;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class InsertionSortListTest {

    private final static String FILENAME = "insertion_sort_list_tests.csv";
    InsertionSortList insertionSortList = new InsertionSortList();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testInsertionSortList(ListNode head) {
        ListNode actual = insertionSortList.insertionSortList(head);
    }


    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToList(csvRecord.get(0))));

    }
}
