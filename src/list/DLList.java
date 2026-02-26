package list;

public class DLList<T> {

    private DNode<T> head;

    private DNode<T> tail;

    public DLList() {
        head = null;
        tail = null;
    }
    public int size() {
        int size = 0;
        DNode<T> current = head;
        while (current != null) {
            current = current.getNext();
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T getHead() {
        if (head == null) {
            return null;
        }
        return head.getElement();
    }

    public T getTail() {
        if (tail == null) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(T element) {
        DNode<T> newNode = new DNode<>(element, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void addLast(T element) {
        DNode<T> newNode = new DNode<>(element, null, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T element = head.getElement();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        return element;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }
        T element = tail.getElement();
        tail = tail.getPrev();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        return element;
    }
}
