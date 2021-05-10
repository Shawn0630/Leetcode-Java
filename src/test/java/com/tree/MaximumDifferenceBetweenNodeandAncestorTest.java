package com.tree;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaximumDifferenceBetweenNodeandAncestorTest {

    private final static String FILENAME = "maximum_difference_between_node_and_ancestor_test_cases.csv";

    private final MaximumDifferenceBetweenNodeandAncestor mdbna = new MaximumDifferenceBetweenNodeandAncestor();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testMaximumDifferenceBetweenNodeAndAncestor(TreeNode root, int expected) {
        assertThat(mdbna.maxAncestorDiff(root), is(expected));
    }


    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToBinaryTree(csvRecord.get(0)),
                        Integer.valueOf(csvRecord.get(1).replace(" ", ""))));
    }
}
