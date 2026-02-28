package iterator;

import stack.DynamicStack;
import tree.BinaryTree;
import tree.TNode;

import java.util.Iterator;

public class BinaryTreeIteratorStack<V> implements Iterator<V> {

    private DynamicStack<TNode<V>> stack = new DynamicStack<>();

    public BinaryTreeIteratorStack(BinaryTree<V> tree) {
        if (tree != null && tree.getRoot() != null) {
            stack.push(tree.getRoot());
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public V next() {
        if (!hasNext()) {
            return null;
        }
        TNode<V> node = stack.pop();
        V value = node.getValue();
        if (node.getRight() != null) {
            stack.push(node.getRight());
        }
        if (node.getLeft() != null) {
            stack.push(node.getLeft());
        }
        return value;
    }

    @Override
    public void remove() {
        this.next();
    }
}
