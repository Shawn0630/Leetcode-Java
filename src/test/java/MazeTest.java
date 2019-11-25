import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MazeTest {

    Maze maze = new Maze();

    @Test
    public void test1() {
        assertTrue(maze.hasPath(new int[][]{{9}}, 0, 0));
        assertThat(maze.minPath(new int[][]{{9}}, 0, 0), is(0));
    }

    @Test
    public void test2() {
        assertTrue(maze.hasPath(new int[][]{{1,1,1,1},{1,0,0,0},{1,9,0,0}}, 0, 0));
    }

    @Test
    public void test3() {
        assertTrue(maze.hasPath(new int[][]{{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,1},{0,0,9,1,1}}, 0, 0));
    }

    @Test
    public void test4() {
        assertFalse(maze.hasPath(new int[][]{{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,0},{0,0,9,0,0}}, 0, 0));
    }
}
