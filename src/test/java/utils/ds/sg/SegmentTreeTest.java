package utils.ds.sg;

import com.TestUtils;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ds.st.SegmentTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SegmentTreeTest {

    private static final String MAX_INTEGER_FILE_NAME = "max_int_segment_tree.csv";

    BiFunction<Integer, Integer, Integer> max = (a, b) -> {
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        return Math.max(a, b);
    };

    @ParameterizedTest
    @MethodSource("generateMaxData")
    void testUpdate(List<Integer> array, int start, int end, int maximum) throws IllegalAccessException {
        SegmentTree<Integer> integerMaxTree = new SegmentTree<>(array.size(), max);
        for(int i = 0; i < array.size(); i++) {
            integerMaxTree.build(i, array.get(i));
        }

        assertThat(integerMaxTree.query(start, end), is(maximum));
    }

    @Test
    public void testVisualize() throws IllegalAccessException {
        SegmentTree<Integer> integerMaxTree = new SegmentTree<>(13, max);
        integerMaxTree.build(2, 3, 5);
        integerMaxTree.build(2, 4, 6);
        integerMaxTree.build(1, 3, 3);
        String svg = integerMaxTree.toSVG();
        try (BufferedWriter out = new BufferedWriter(new FileWriter("test.svg"))) {
            out.write(svg);
        } catch (IOException e) {
            System.out.println("Exception ");
        }
    }

    @ParameterizedTest
    @MethodSource("generateMaxData")
    void testBuild(List<Integer> array, int start, int end, int maximum) throws IllegalAccessException {
        SegmentTree<Integer> integerMaxTree = new SegmentTree<>(array.toArray(new Integer[0]), max);

        assertThat(integerMaxTree.query(start, end), is(maximum));
    }

    static Stream<Arguments> generateMaxData() throws IOException {
        return TestUtils.fetchCSVRecord(MAX_INTEGER_FILE_NAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToIntegerList(record.get(0).replace(" ", "")),
                        Integer.valueOf(record.get(1).replace(" ", "")),
                        Integer.valueOf(record.get(2).replace(" ", "")),
                        Integer.valueOf(record.get(3).replace(" ", ""))));
    }
}
