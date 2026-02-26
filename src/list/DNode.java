package list;

public class DNode<T> {

    private T element;

    private DNode<T> prev;

    private DNode<T> next;

    public DNode(T element,DNode<T> prev, DNode<T> next) {
        setElement(element);
        setPrev(prev);
        setNext(next);
        if (prev == null) {
            this.prev = this;
        }
        if (next == null) {
            this.next = this;
        }
    }

    public T getElement() {
        return element;
    }

    public void setElement(T elemnet) {
        this.element = elemnet;
    }

    public DNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }
}
