package utils.ds.tree.visualization;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import utils.ds.st.SegmentTreeNode;
import utils.ds.tree.TreeFactory;
import utils.ds.tree.model.BinaryTreeNode;
import utils.ds.tree.model.TreeNode;
import utils.ds.tree.visualization.svg.SVGForTextInBoxTree;
import utils.ds.tree.visualization.swing.TextInBoxTreePane;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

public class TreeVisualizer {
    // setup the tree layout configuration
    private final double GAP_BETWEEN_LEVELS = 50;
    private final double GAP_BETWEEN_NODES = 10;

    public <T, K extends TreeNode<T>> void visualizeTreeInSwing(K root, Function<K, String> labelGenerator) {
        TreeForTreeLayout<TextInBox> tree = TreeFactory.buildTree(root, labelGenerator);

        DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<>(GAP_BETWEEN_LEVELS, GAP_BETWEEN_NODES);
        // create the NodeExtentProvider for TextInBox nodes
        TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();

        // create the layout
        TreeLayout<TextInBox> treeLayout = new TreeLayout<>(tree,
                nodeExtentProvider, configuration);

        // Create a panel that draws the nodes and edges and show the panel
        TextInBoxTreePane panel = new TextInBoxTreePane(treeLayout);
        showInDialog(panel);
    }

    public <T, K extends TreeNode<T>> String toSVG(K root, Function<K, String> labelGenerator) {
        TreeForTreeLayout<TextInBox> tree = TreeFactory.buildTree(root, labelGenerator);

        DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<>(GAP_BETWEEN_LEVELS, GAP_BETWEEN_NODES);

        // create the NodeExtentProvider for TextInBox nodes
        TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();

        TreeLayout<TextInBox> treeLayout = new TreeLayout<TextInBox>(tree, nodeExtentProvider, configuration);

        SVGForTextInBoxTree generator = new SVGForTextInBoxTree(treeLayout);

        return generator.getSVG();
    }

    private static void showInDialog(JComponent panel) {
        JDialog dialog = new JDialog();
        Container contentPane = dialog.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));
        contentPane.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

}
