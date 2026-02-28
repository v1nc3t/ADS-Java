package iterator;

import tree.BinaryTree;
import tree.InvalidNodeException;
import tree.TNode;

import java.util.Iterator;

public class BinaryTreeIterator<V> implements Iterator<V> {

    private BinaryTree<V> tree;

    private TNode<V> cursor;

    private BinaryTreeIterator(BinaryTree<V> tree) {
        this.tree = tree;
        if (tree != null) {
            this.cursor = tree.getRoot();
        } else {
            this.cursor = null;
        }
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public V next() {
        if (!hasNext()) {
            return null;
        }
        V value = cursor.getValue();
        if (cursor.getLeft() != null) {
            cursor = cursor.getLeft();
        } else if (cursor.getRight() != null) {
            cursor = cursor.getRight();
        } else {
            TNode<V> parent = cursor.getParent();
            TNode<V> child = cursor;
            while (parent != null && (parent.getRight() == null || parent.getRight() == child)) {
                child = parent;
                parent = parent.getParent();
            }
            if (parent == null) {
                cursor = null;
            } else {
                cursor = parent.getRight();
            }
        }
        return value;
    }

    @Override
    public void remove() {
        this.next();
    }

}
