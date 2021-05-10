package com.greedy;

import com.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskSchedulerTests {
    private final static String FILENAME = "task_scheduler_test_cases.csv";

    TaskScheduler ts = new TaskScheduler();

    @ParameterizedTest
    @MethodSource("generateData")
    void testTaskScheduler(char[] tasks, int n, int expected) {
       assertEquals(expected, ts.leastInterval(tasks, n));
    }

    static Stream<Arguments> generateData() throws IOException {
        return TestUtils.fetchCSVRecord(FILENAME).stream()
                .map(record -> Arguments.of(TestUtils.convertToCharArray(record.get(0)),
                        Integer.valueOf(record.get(1).replace(" ", "")),
                        Integer.valueOf(record.get(2).replace(" ", ""))));
    }
}
