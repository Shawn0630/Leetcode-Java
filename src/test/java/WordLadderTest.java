import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;


import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WordLadderTest {

    WordLadder wl = new WordLadder();

    @Test
    public void test1() {
        assertThat(wl.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")), is(5));
        assertThat(wl.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")),
                containsInAnyOrder(Arrays.asList("hit","hot","dot","dog","cog"), Arrays.asList("hit","hot","lot","log","cog")));
    }

    @Test
    public void test2() {
        assertThat(wl.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")), is(0));
        assertThat(wl.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")),
                containsInAnyOrder(Collections.emptyList()));
    }

    @Test
    public void test3() {
        assertThat(wl.findLadders("a", "c", Arrays.asList("a", "b", "c")), containsInAnyOrder(Arrays.asList("a", "c")));
    }

    @Test
    public void test4() {
        assertThat(wl.findLadders("a", "a", Arrays.asList("a", "b", "c")), containsInAnyOrder(Arrays.asList("a")));
    }

    @Test
    public void test5() {
        assertThat(wl.findLadders("hot", "dog", Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot")), containsInAnyOrder(
                Arrays.asList("hot","dot","dog"),
                Arrays.asList("hot","hog","dog")
        ));
    }
}
