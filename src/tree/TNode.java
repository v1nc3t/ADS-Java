package tree;

public class TNode<V> {

    private int key;

    private V value;

    private TNode<V> parent, left, right;

    public TNode(int key, V value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public TNode<V> getParent() {
        return this.parent;
    }

    public TNode<V> getLeft() {
        return this.left;
    }

    public TNode<V> getRight() {
        return this.right;
    }

    public void setParent(TNode<V> parent) {
        this.parent = parent;
    }

    public void setLeft(TNode<V> left) {
        this.left = left;
    }

    public void setRight(TNode<V> right) {
        this.right = right;
    }
}
