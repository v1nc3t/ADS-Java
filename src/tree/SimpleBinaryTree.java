package tree;

public class SimpleBinaryTree {

    private int key;

    private SimpleBinaryTree left, right;

    public SimpleBinaryTree(int key) {
        this.key = key;
    }

    public SimpleBinaryTree(int key, SimpleBinaryTree left, SimpleBinaryTree right) {
        this.key = key;
        setLeft(left);
        setRight(right);
    }

    public int getKey() {
        return key;
    }

    public SimpleBinaryTree getLeft() {
        return left;
    }

    public SimpleBinaryTree getRight() {
        return right;
    }

    public boolean hasLeft() {
        return left != null;
    }
    public boolean hasRight() {
        return right != null;
    }

    public void setLeft(SimpleBinaryTree left) {
        this.left = left;
    }

    public void setRight(SimpleBinaryTree right) {
        this.right = right;
    }
}
