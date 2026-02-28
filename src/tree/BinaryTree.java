package tree;

public class BinaryTree<V> {

    private TNode<V> root;

    public BinaryTree() {
        this.root = null;
    }

    public TNode<V> getRoot() {
        return root;
    }

    public TNode<V> getLeft(TNode<V> node) throws InvalidNodeException {
        return checkNode(node).getLeft();
    }

    public TNode<V> getRight(TNode<V> node) throws InvalidNodeException {
        return checkNode(node).getRight();
    }

    public boolean hasLeft(TNode<V> node) throws InvalidNodeException {
        return checkNode(node).getLeft() != null;
    }

    public boolean hasRight(TNode<V> node) throws InvalidNodeException {
        return checkNode(node).getRight() != null;
    }

    public void add(int key, V value) {
        if (root == null) {
            root = new TNode<>(key, value);
        } else {
            this.add(root, new TNode<>(key, value));
        }
    }

    private void add(TNode<V> node, TNode<V> newNode) {
        if (node.getKey() == newNode.getKey()) {
            node.setValue(newNode.getValue());
        } else {
            if (node.getKey() > newNode.getKey()) {
                if (node.getLeft() == null) {
                    newNode.setParent(node);
                    node.setLeft(newNode);
                }  else {
                    this.add(node.getLeft(), newNode);
                }
            } else {
                if (node.getRight() == null) {
                    newNode.setParent(node);
                    node.setRight(newNode);
                } else {
                    this.add(node.getRight(), newNode);
                }
            }
        }

    }

    private TNode<V> checkNode(TNode<V> node) throws InvalidNodeException {
        if (node == null) {
            throw new InvalidNodeException("Null Node");
        }
        return node;
    }
}

