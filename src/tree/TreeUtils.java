package tree;

import queue.EmptyQueueException;
import queue.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeUtils {

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
}
