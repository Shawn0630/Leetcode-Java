package utils.ds.st;

import java.util.Arrays;
import java.util.function.BiFunction;

public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        segmentTree = new SegmentTree<>(Arrays.stream(nums).boxed().toArray(Integer[]::new), Integer::sum);
    }

    public void update(int index, int val) {
        segmentTree.modify(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }

    private class SegmentTree<T> {
        /*
         * Build - O(n)
         */
        private BiFunction<T, T, T> transformer;
        private SegmentTreeNode<T> root;

        public SegmentTree(T[] arr, BiFunction<T, T, T> transformer) {
            this.transformer = transformer;
            this.root = build(arr);
        }

        public SegmentTreeNode<T> build(T[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            return build(arr, 0, arr.length - 1);
        }
        /*
         * Search - O(logn)
         */
        void modify(int index, T value) {
            modify(this.root, index, value);
        }
        /*
         * Modification - O(logn)
         */
        T query(int start, int end) {
            return query(this.root, start, end);
        }

        private SegmentTreeNode<T> build(T[] arr, int start, int end) {
            if (start > end) {
                return null;
            }

            SegmentTreeNode<T> root = new SegmentTreeNode<>(start, end);
            if (start == end) {
                root.attribute = arr[start];
                return root;
            }

            int mid = (start + end) >> 1;
            root.left = build(arr, start, mid);
            root.right = build(arr, mid + 1, end);
            root.attribute = transformer.apply(root.left.attribute, root.right.attribute);
            return root;
        }

        private T query(SegmentTreeNode<T> root, int start, int end) {
            if (root == null) {
                return null;
            }

            // case 1: search range is same with the range of root node
            if (root.start == start && root.end == end) {
                return root.attribute;
            }

            int mid = (root.start + root.end) >> 1;
            // left range = [root.start, root.mid], right range = [root.mid + 1, root.end]
            if (end <= mid) {
                // case 2: search range is in the range of left child node
                return query(root.left, start, end);
            } else if (start > mid) {
                // case 3: search range is in the range of right child node
                return query(root.right, start, end);
            } else {
                //case 4: search range crosses both left and right children
                T left = query(root.left, start, mid);
                T right = query(root.right, mid + 1, end);
                return transformer.apply(left, right);
            }
        }

        private void modify(SegmentTreeNode<T> root, int index, T value) {
            if (root == null) {
                return;
            }

            if (root.start == root.end && root.start == index) {
                root.attribute = value;
                return;
            }

            int mid = root.start + (root.end - root.start) / 2;
            if (index <= mid) {
                modify(root.left, index, value);
            } else {
                modify(root.right, index, value);
            }

            root.attribute = transformer.apply(root.left.attribute, root.right.attribute);
        }
    }

    private class SegmentTreeNode<T> {
        public int start, end;
        public T attribute;
        public SegmentTreeNode<T> left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }
}
