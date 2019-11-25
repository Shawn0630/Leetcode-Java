package com.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class NQueensTest {

    NQueens nq = new NQueens();

    @Test
    public void test1() {
        assertThat(nq.solveNQueens(4), containsInAnyOrder(
                Arrays.asList(
                        ".Q..",
                        "...Q",
                        "Q...",
                        "..Q."
                ),
                Arrays.asList(
                        "..Q.",
                        "Q...",
                        "...Q",
                        ".Q.."
                )
        ));
        assertThat(nq.totalNQueens(4), is(2));
    }
}
