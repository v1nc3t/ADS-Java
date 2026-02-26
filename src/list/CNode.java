package list;

public class CNode<T> {

    private T element;

    private CNode<T> next;

    public CNode(T element, CNode<T> next) {
        setElement(element);
        setNext(next);
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

    public CNode<T> getNext() {
        return next;
    }

    public void setNext(CNode<T> next) {
        this.next = next;
    }
}
