package tree;

public class OneTwoTree {

    private int key;

    private OneTwoTree left, right;

    public OneTwoTree(int key) {
        this.key = key;
    }

    public OneTwoTree(int key, OneTwoTree left, OneTwoTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public OneTwoTree getLeft() {
        return left;
    }

    public OneTwoTree getRight() {
        return right;
    }

    public void setLeft(OneTwoTree left) {
        this.left = left;
    }

    public void setRight(OneTwoTree right) {
        this.right = right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public  boolean hasRight() {
        return right != null;
    }

    public boolean get(int i) {
        if (i == this.key) {
            return true;
        } else if (i < this.getKey() && hasLeft()) {
            return left.get(i);
        } else if (i > this.getKey() && hasRight()) {
            return right.get(i);
        }
        return false;
    }

    public void put(int i) {
        if (i < this.key) {
            if (hasLeft()) {
                left.put(i);
            } else {
                left = new OneTwoTree(i);
            }
        } else if (i > this.key) {
            if (hasRight()) {
                right.put(i);
            } else {
                right = new OneTwoTree(i);
            }
        }
    }

    public void remove(int i) {
        if (i == this.key) {
            if (hasLeft() || hasRight()) {
                OneTwoTree dummy = deleteRecursive(this, i);
            }
            return;
        }

        if (i < this.key && left != null) {
            left = deleteRecursive(left, i);
        } else if (i > this.key && right != null) {
            right = deleteRecursive(right, i);
        }
    }

    private OneTwoTree deleteRecursive(OneTwoTree node, int i) {
        if (node == null) {
            return null;
        }
        if (i < node.key) {
            node.left = deleteRecursive(node.left, i);
        } else if (i > node.key) {
            node.right = deleteRecursive(node.right, i);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return  node.left;
            }

            node.setKey(minValue(node.right));
            node.right = deleteRecursive(node.right, node.getKey());
        }
        return node;
    }

    private int minValue(OneTwoTree node) {
        int minv = node.key;
        while (node.left != null) {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }
}
