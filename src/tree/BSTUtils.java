package tree;

import java.util.ArrayList;
import java.util.List;

public final class BSTUtils {

    /**
     * Return all elements in the given BST in descending order.
     *
     * @param tree
     *     The BST to traverse.
     * @return A list of all elements in descending order.
     */
    public static List<Integer> descendingOrderFlatten(BinaryTree<Integer> tree) {
        List<Integer> result = new ArrayList<>();
        reverseInOrder(tree.getRoot(), result);
        return result;
    }

    private static <V> void reverseInOrder(TNode<Integer> node, List<Integer> result) {
        if (node == null) {
            return;
        }

        reverseInOrder(node.getRight(), result);
        result.add(node.getValue());
        reverseInOrder(node.getLeft(), result);
    }

    /**
     * Computes whether the BinaryTree is a binary search tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     */
    public static boolean isTreeBST(BinaryTree<Integer> tree) {
        return isBSTHelper(tree.getRoot(), Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private static boolean isBSTHelper(TNode<Integer> node, int mn, int mx) {
        if (node == null) {
            return true;
        }

        if (node.getValue() <= mn) {
            return false;
        }
        if (node.getValue() >= mx) {
            return false;
        }

        return isBSTHelper(node.getLeft(), mn, node.getValue())
                && isBSTHelper(node.getRight(), node.getValue(), mx);
    }

    /**
     * This method checks whether the given tree has the height-balance property.
     *
     * @param tree
     *     the tree to check.
     * @return true iff the tree has the height-balance property, false otherwise.
     */
    public static <V> boolean isTreeBalanced(BinaryTree<V> tree) {
        return height(tree.getRoot()) != -1;
    }

    private static <V> int height(TNode<V> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.getLeft());
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.getRight());
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
