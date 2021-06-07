package utils.ds.tree.binarytree;

import utils.ds.tree.binarytree.contructor.BinaryTreeConstructor;
import utils.ds.tree.binarytree.contructor.BinaryTreeIterativeConstructor;
import utils.ds.tree.binarytree.model.BinaryTreeNode;
import utils.ds.tree.binarytree.traversal.BinaryTreeIterativeTraversal;
import utils.ds.tree.binarytree.traversal.BinaryTreeTraversal;
import utils.ds.tree.binarytree.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.ds.tree.binarytree.utils.BinaryTreeTestUtils.node;

public class BinaryTreeGenerator {
//    public static BinaryTreeNode<Integer> binaryTreeGenerator(int n){
//        if (n == 0)
//            return null;
//
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(random.nextInt(MAX_RAND_NUM));
//
//        // Number of nodes in the left subtree (in [0, n-1])
//        int leftN = random.nextInt(n);
//
//        // Recursively build each subtree
//        root.left = binaryTreeGenerator(leftN);
//        root.right = binaryTreeGenerator(n - leftN - 1);
//
//        return root;
//    }

    public static BinaryTreeNode<Integer> binaryTreeGenerator(int n) {
        BinaryTreeConstructor<Integer> builder = new BinaryTreeIterativeConstructor<>();
        String wellBalancedString = BracketStringUtils.generateWellBalancedWord(n);
        return builder.constructFromBracketString(wellBalancedString, BracketStringUtils.LEFT_BRACKET, BracketStringUtils.RIGHT_BRACKET);
    }

    public static void main(String[] args) throws Exception {
        /*
        * Sample code
        */
        //BinaryTreeNode<Integer> root = node(node(null, 1, null), 0, node(null,2, null));
//        BinaryTreeNode<Integer> root = node(null, 0, node(null, 1, node(null, 2, null)));
//        StringBuilder sb = new StringBuilder();
//        BinaryTreeTraversal<Integer> treeTraversal = new BinaryTreeIterativeTraversal<>();
//        treeTraversal.postorderTraversal(root, (integer -> sb.append(BracketStringUtils.LEFT_BRACKET)), (integer -> sb.append(BracketStringUtils.RIGHT_BRACKET)));
//        System.out.println(sb.toString());
//        StringBuilder sb2 = new StringBuilder();
//        treeTraversal.inorderTraversal(root, (integer -> sb2.append(BracketStringUtils.LEFT_BRACKET)), (integer -> sb2.append(BracketStringUtils.RIGHT_BRACKET)));
//        System.out.println(sb2.toString());

        int N = 10;
        List<String[]> testData = new ArrayList<>();
        BinaryTreeTraversal<Integer> treeTraversal = new BinaryTreeIterativeTraversal<>();

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                List<String> data = new ArrayList<>();
                BinaryTreeNode<Integer> testCase = binaryTreeGenerator(i);
                StringBuilder sb = new StringBuilder();
                treeTraversal.inorderTraversal(testCase, (integer -> sb.append(BracketStringUtils.LEFT_BRACKET)), (integer -> sb.append(BracketStringUtils.RIGHT_BRACKET)));
                data.add(sb.toString());
                data.add(Integer.toString(i));
                testData.add(data.toArray(new String[0]));
            }

        }

        CSVUtils.saveToCSV("tree_test_cases.csv", testData);
    }
}
