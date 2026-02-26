package list;

public class SLList<T> {

    private SNode<T> head;

    private SNode<T> tail;

    private int size;

    public SLList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
        SNode<T> newNode = new SNode<>(element, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void addTail(T element) {
        SNode<T> newNode = new SNode<>(element, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T element = head.getElement();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return element;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T element = tail.getElement();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            SNode<T> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
        size--;
        return element;
    }
}