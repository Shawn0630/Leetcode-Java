package utils.ds.tree.binarytree.constructor;

import utils.ds.tree.binarytree.contructor.BinaryTreeConstructor;
import utils.ds.tree.binarytree.contructor.BinaryTreeIterativeConstructor;
import utils.ds.tree.binarytree.contructor.BinaryTreeRecursiveConstructor;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeConstructorTests {
    BinaryTreeConstructor<Integer> recursive = new BinaryTreeRecursiveConstructor<>();
    BinaryTreeConstructor<Integer> iterative = new BinaryTreeIterativeConstructor<>();

//    @ParameterizedTest
//    @MethodSource("constructor")
//    public void testInPreConstructor(List<Integer> list1, List<Integer> list2,) {
//        assertThat(recursive.constructFromInPre(list1, list2));
//    }
}
