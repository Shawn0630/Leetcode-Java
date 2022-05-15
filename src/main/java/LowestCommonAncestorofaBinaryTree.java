public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (root == p || root == q) {
                return root;
            } else if (left != null && right != null) {
                return root;
            } else if (left == null && right == null) {
                return null;
            } else { //left != null || right != null
                return left == null ? right : left;
            }
        }
    }

    //            a
    //      b           c
    //  d(d)     e(e)             f

    // low(d, e) = b
    // low(d, f) = a
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p) {
            return p;
        } else if (root == q) {
            return q;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left == null && right == null) { // opposite left != null || right != null
            return null;
        } else if (left == null) { // right != null
            return right;
        } else if (right == null) { // left != null
            return left;
        } else { // left != null && right != null
            return root;
        }
    }


    //               a
    //     b                c
    //  d(found,d)   e         f

    // low(d, g) = null
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) { // p, q could not exists

        Ancestor ancestor = lowest(root, p, q,false, false);

        return ancestor.foundP && ancestor.foundQ ? ancestor.ancestor : null;

    }

    private Ancestor lowest(TreeNode root, TreeNode p, TreeNode q, boolean foundP, boolean foundQ) {
        if (root == null) {
            return new Ancestor(foundP, foundQ, null);
        }


        Ancestor left = lowest(root.left, p, q, foundP, foundQ);
        Ancestor right = lowest(root.right, p, q, foundP, foundQ);

        boolean PFound = left.foundP || right.foundP || foundP;
        boolean QFound = left.foundQ || right.foundQ || foundQ;

        if (root == p) {
            return new Ancestor(true, QFound, root);
        } else if (root == q) {
            return new Ancestor(PFound, true, root);
        }

        if (left.ancestor == null && right.ancestor == null) {
            return new Ancestor(foundP, foundQ, null);
        } else  { // right.ancestor != null

            if (left.ancestor == null) {
                return new Ancestor(PFound, QFound, right.ancestor);
            } else if (right.ancestor == null) {
                return new Ancestor(PFound, QFound, left.ancestor);
            } else {
                return new Ancestor(PFound, QFound, root);
            }
        }
    }

    private class Ancestor {
        boolean foundQ;
        boolean foundP;
        TreeNode ancestor;

        public Ancestor(boolean foundP, boolean foundQ, TreeNode ancestor) {
            this.foundP = foundP;
            this.foundQ = foundQ;
            this.ancestor = ancestor;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
