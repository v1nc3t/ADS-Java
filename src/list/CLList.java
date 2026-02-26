package list;

public class CLList<T> {

    private CNode<T> cursor;

    private int size;

    public CLList() {
        this.cursor = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public CNode<T> getFirst() {
        return this.cursor;
    }

    public CNode<T> getLast() {
        if (cursor == null) {
            return null;
        }
        CNode<T> finger = cursor;
        while (finger.getNext() != cursor) {
            finger = finger.getNext();
        }
        return finger;
    }

    public CNode<T> getNext(CNode<T> node) {
        return node.getNext();
    }

    public CNode<T> getPrev(CNode<T> node) {
        CNode<T> finger = getFirst();
        if (finger == null) {
            return null;
        }
        int count = 0;
        while (finger.getNext() != node && count++ < size) {
            finger = finger.getNext();
        }
        return finger;
    }

    public void addFirst(T o) {
        if (this.cursor == null) {
            cursor = new CNode<>(o, null);
            cursor.setNext(cursor);
        } else {
            CNode<T> last = getLast();
            CNode<T> newNode = new CNode<>(o, cursor);
            last.setNext(newNode);
            cursor = newNode;
        }
        size++;
    }

    public void addLast(T o) {
        if (cursor == null) {
            addFirst(o);
        } else {
            CNode<T> last = getLast();
            CNode<T> newNode = new CNode<>(o, cursor);
            last.setNext(newNode);
            size++;
        }
    }

    public void addAfter(CNode<T> node, T o) {
        CNode<T> newNode = new CNode<>(o, node.getNext());
        node.setNext(newNode);
        size++;
    }

    public void addBefore(CNode<T> node, T o) {
        CNode<T> prev = getPrev(node);
        CNode<T> newNode = new CNode<>(o, node);
        prev.setNext(newNode);
        if (node == cursor){
            cursor = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T element = cursor.getElement();
        if (size == 1) {
            cursor = null;
        } else {
            CNode<T> last = getLast();
            cursor = cursor.getNext();
            last.setNext(cursor);
        }
        size--;
        return element;
    }

    public T remove(CNode<T> node) {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            cursor = null;
        } else {
            CNode<T> prev = getPrev(node);
            if (node == cursor) cursor = node.getNext();
            prev.setNext(node.getNext());
        }
        size--;
        node.setNext(null);
        return node.getElement();
    }

    public T set(CNode<T> node, T o) {
        T prev = node.getElement();
        node.setElement(o);
        return prev;
    }

}
