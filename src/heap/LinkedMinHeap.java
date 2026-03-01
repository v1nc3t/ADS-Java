package heap;

public class LinkedMinHeap<T extends Comparable<T>> {

    private HNode<T> root;

    private int size = 0;

    public LinkedMinHeap(HNode<T> root) {
        this.root = root;
        this.size = (root == null) ? 0 : 1;
    }

    public int size() {
        return size;
    }

    public HNode<T> peek() {
        return root;
    }

    public HNode<T> getLeft(HNode<T> node) {
        return node.getLeft();
    }

    public HNode<T> getRight(HNode<T> node) {
        return node.getRight();
    }

    public boolean hasLeft(HNode<T> node) {
        return node.getLeft() != null;
    }

    public boolean hasRight(HNode<T> node) {
        return node.getRight() != null;
    }

    public void add(int key, T value) {
        HNode<T> newNode = new HNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            insertAtLast(newNode);
            bubbleUp(newNode);
        }
        size++;
    }

    private void insertAtLast(HNode<T> newNode) {
        String path = Integer.toBinaryString(size + 1).substring(1);

        HNode<T> curr = root;
        for (int i = 0; i < path.length() - 1; i++) {
            if (path.charAt(i) == '0') {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }

        if (path.charAt(path.length() - 1) == '0') {
            curr.setLeft(newNode);
        } else {
            curr.setRight(newNode);
        }
        newNode.setParent(curr);
    }

    private void bubbleUp(HNode<T> node) {
        while (node.getParent() != null) {
            HNode<T> parent = node.getParent();
            if (node.getKey() < parent.getKey()) {
                int tempKey = node.getKey();
                T tempVal = node.getValue();

                node.setKey(parent.getKey());
                node.setValue(parent.getValue());

                parent.setKey(tempKey);
                parent.setValue(tempVal);
                node = parent;
            } else break;
        }
    }

    public HNode<T> poll() {
        if (root == null) {
            return null;
        }

        HNode<T> result = new HNode<>(root.getKey(), root.getValue());

        if (size == 1) {
            root = null;
        } else {
            HNode<T> lastNode = findLastNode();

            root.setKey(lastNode.getKey());
            root.setValue(lastNode.getValue());

            HNode<T> parent = lastNode.getParent();
            if (parent.getLeft() == lastNode) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

            bubbleDown(root);
        }
        size--;
        return result;
    }

    private HNode<T> findLastNode() {
        String path = Integer.toBinaryString(size).substring(1);
        HNode<T> curr = root;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '0') {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        return curr;
    }

    private void bubbleDown(HNode<T> node) {
        while (hasLeft(node)) {
            HNode<T> smallerChild = node.getLeft();
            if (hasRight(node) && node.getRight().getKey() < node.getLeft().getKey()) {
                smallerChild = node.getRight();
            }

            if (node.getKey() <= smallerChild.getKey()) {
                break;
            }

            int tempKey = node.getKey();
            T tempVal = node.getValue();

            node.setKey(smallerChild.getKey());
            node.setValue(smallerChild.getValue());

            smallerChild.setKey(tempKey);
            smallerChild.setValue(tempVal);

            node = smallerChild;
        }
    }
}

