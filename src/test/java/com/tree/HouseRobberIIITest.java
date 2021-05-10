package com.tree;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberIIITest {

    private static final String TEST_FILE = "house_robber_III.csv";

    HouseRobberIII houseRobberIII = new HouseRobberIII();

    @ParameterizedTest
    @MethodSource("generateData")
    public void testHouseRobberIII(TreeNode root, int expected) {
        assertEquals(expected, houseRobberIII.rob(root));
    }

    private static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(TEST_FILE).stream()
                .map(csvRecord -> Arguments.of(TestUtils.convertToBinaryTree(csvRecord.get(0)),
                        Integer.valueOf(csvRecord.get(1).replace(" ", ""))));
    }
}
