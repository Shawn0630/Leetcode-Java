import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class HuaweiSolutionTest2 {

    HuaweiSolution2 h2 = new HuaweiSolution2();

    @Test
    public void test1() {
        HuaweiSolution2.Node root = new HuaweiSolution2.Node(1, new HuaweiSolution2.Node(2, null, null), new HuaweiSolution2.Node(3, null, null));
        HuaweiSolution2.Node croot = h2.cpNode(root);
        assertThat(croot.getValue(), is(1));
        assertThat(croot.getLC().getValue(), is(2));
        assertThat(croot.getRC().getValue(), is(3));
    }

    @Test
    public void test2() {
        HuaweiSolution2.Node root = new HuaweiSolution2.Node(1, new HuaweiSolution2.Node(2, null, null), null);
        HuaweiSolution2.Node croot = h2.cpNode(root);
        assertThat(croot.getValue(), is(1));
        assertThat(croot.getLC().getValue(), is(2));
        assertEquals(croot.getRC(), null);
    }


    @Test
    public void test3() {
        HuaweiSolution2.Node left = new HuaweiSolution2.Node(5, new HuaweiSolution2.Node(1, null, new HuaweiSolution2.Node(3, null, null)), new HuaweiSolution2.Node(3, null, null));
        HuaweiSolution2.Node right = new HuaweiSolution2.Node(2, new HuaweiSolution2.Node(5, null, null), new HuaweiSolution2.Node(6, null, new HuaweiSolution2.Node(3, null, null)));

        HuaweiSolution2.Node result = h2.add(left, right);

        assertThat(result.getValue(), is(7));
        assertThat(result.getLC().getValue(), is(6));
        assertThat(result.getRC().getValue(), is(9));
        assertEquals(result.getLC().getLC(), null);
    }
}
