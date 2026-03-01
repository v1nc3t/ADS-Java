package tree;

import queue.EmptyQueueException;
import queue.Queue;
import stack.DynamicStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeUtils {

    public static <T> List<T> preOrderIterative(BinaryTree<T> tree) {
        List<T> result = new ArrayList<>();
        if (tree == null || tree.getRoot() == null) {
            return result;
        }

        DynamicStack<TNode<T>> stack = new DynamicStack<>();
        stack.push(tree.getRoot());
        while (!stack.isEmpty()) {
            TNode<T> node = stack.pop();

            result.add(node.getValue());

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        return result;
    }

    public static <T> List<T> preOrderRecursive(BinaryTree<T> tree) {
        List<T> result = new ArrayList<>();
        if (tree != null) {
            preOrder(tree.getRoot(), result);
        }
        return result;
    }

    private static <T> void preOrder(TNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.getValue());
        preOrder(node.getLeft(), result);
        preOrder(node.getRight(), result);
    }

    public static <T> List<T> inOrderIterative(BinaryTree<T> tree) {
        List<T> result = new ArrayList<>();
        if (tree == null || tree.getRoot() == null) {
            return result;
        }

        DynamicStack<TNode<T>> stack = new DynamicStack<>();
        stack.push(tree.getRoot());
        while (!stack.isEmpty()) {
            TNode<T> node = stack.pop();

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }

            result.add(node.getValue());

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        return result;
    }

    public static <T> List<T> inOrderRecursive(BinaryTree<T> tree) {
        List<T> result = new ArrayList<>();
        if (tree != null) {
            inOrder(tree.getRoot(), result);
        }
        return result;
    }

    private static <T> void inOrder(TNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft(), result);
        result.add(node.getValue());
        inOrder(node.getRight(), result);
    }

    public static <T> List<T> postOrderIterative(BinaryTree<T> tree) {
        List<T> result = new ArrayList<>();
        if (tree == null || tree.getRoot() == null) {
            return result;
        }

        DynamicStack<TNode<T>> stack = new DynamicStack<>();
        stack.push(tree.getRoot());
        while (!stack.isEmpty()) {
            TNode<T> node = stack.pop();

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }

            result.add(node.getValue());

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        return result;
    }

    public static <T> List<T> postOrderRecursive(BinaryTree<T> tree) {
        List<T> result = new ArrayList<>();
        if (tree != null) {
            postOrder(tree.getRoot(), result);
        }
        return result;
    }

    private static <T> void postOrder(TNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft(), result);
        postOrder(node.getRight(), result);
        result.add(node.getValue());
    }


    /**
     * Creates a hard copy of the n-ary tree.
     * @param t The tree to create a copy of
     * @return a new tree in which every node contains the values of the nodes at the corresponding positions in t
     */
    public static <T> Tree<T> copy(Tree<T> t) {
        if (t == null) {
            return null;
        }
        ArrayList<Tree<T>> copyChildren = new ArrayList<>();
        for (Tree<T> child : t.getChildren()) {
            copyChildren.add(copy(child));
        }
        return new Tree<T>(t.getObject(), copyChildren);
    }

    /**
     * Computes whether the BinaryTree is complete.
     *
     * @param root
     *     the SimpleBinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isBinaryTreeComplete(SimpleBinaryTree root) throws EmptyQueueException {
        if (root == null) {
            return true;
        }

        Queue<SimpleBinaryTree> queue = new Queue<>();
        queue.enqueue(root);

        boolean foundNull = false;

        while (!queue.isEmpty()) {
            SimpleBinaryTree current = queue.dequeue();

            if (current == null) {
                foundNull = true;
            } else {
                if (foundNull) {
                    return false;
                }
                queue.enqueue(current.getLeft());
                queue.enqueue(current.getRight());
            }
        }
        return true;
    }

    /**
     * Sums the values of the nodes of two n-ary trees.
     * @param t1 - first tree to sum values for
     * @param t2 - second tree to sum values for
     * @return a new tree in which every node contains the sum of the values of the nodes at the corresponding positions in t1 and t2
     */
    public static Tree<Integer> sumSame(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        List<Tree<Integer>> sumChildren = new ArrayList<>();
        List<Tree<Integer>> c1 = t1.getChildren();
        List<Tree<Integer>> c2 = t2.getChildren();

        for (int i = 0; i < c1.size(); i++) {
            sumChildren.add(sumSame(c1.get(i), c2.get(i)));
        }
        return new Tree<>(t1.getObject() + t2.getObject(), sumChildren);
    }

    public static Tree<Integer> sumDifferent(Tree<Integer> t1, Tree<Integer> t2) throws DifferentShapesException {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            throw new DifferentShapesException();
        }
        if (t2 == null) {
            throw new DifferentShapesException();
        }
        List<Tree<Integer>> sumChildren = new ArrayList<>();
        List<Tree<Integer>> c1 = t1.getChildren();
        List<Tree<Integer>> c2 = t2.getChildren();

        if (c1.size() != c2.size()) {
            throw new DifferentShapesException();
        }

        for (int i = 0; i < c1.size(); i++) {
            sumChildren.add(sumDifferent(c1.get(i), c2.get(i)));
        }
        return new Tree<>(t1.getObject() + t2.getObject(), sumChildren);
    }
}
