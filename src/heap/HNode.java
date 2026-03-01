package heap;

public class HNode<T extends Comparable<T>> {

    private int key;

    private T value;

    private HNode<T> parent, left, right;

    public HNode(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public HNode<T> getParent() {
        return parent;
    }

    public void setParent(HNode<T> parent) {
        this.parent = parent;
    }

    public HNode<T> getLeft() {
        return left;
    }

    public void setLeft(HNode<T> left) {
        this.left = left;
    }

    public HNode<T> getRight() {
        return right;
    }

    public void setRight(HNode<T> right) {
        this.right = right;
    }
}
