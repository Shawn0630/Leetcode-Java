public class HuaweiSolution2 {
    // The Node class is provided to you
    public static class Node
    {
        private int value;
        private Node left;
        private Node right;

        public Node(int v, Node left, Node right) {
            this.value = v;
            this.left = left;
            this.right = right;
        }
        public int getValue() {
            return this.value;
        }
        public Node getLC() {
            return this.left;
        }
        public Node getRC() {
            return this.right;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public void setLC(Node n) {
            this.left = n;
        }
        public void setRC(Node n) {
            this.right = n;
        }
    }

    //OPTIONAL -- see the description for cpNode in the Notes section
    public Node cpNode(Node t) {
        if(t == null) {
            return null;
        }

        Node cLC = cpNode(t.left);
        Node cRC = cpNode(t.right);
        return new Node(t.value, cLC, cRC);
    }

    public Node add(Node t1, Node t2) {
        //
        // Implement your solution here
        //
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 == null) {
            return cpNode(t1);
        } else if (t2 != null && t1 == null) {
            return cpNode(t2);
        } else {
            Node addLC = add(t1.left, t2.left);
            Node addRC = add(t1.right, t2.right);

            return new Node(t1.getValue() + t2.getValue(), addLC, addRC);
        }
    }

}
