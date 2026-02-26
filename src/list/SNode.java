package list;

public class SNode<T> {

    private T element;

    private SNode<T> next;

    public SNode(T element, SNode<T> next) {
        setElement(element);
        setNext(next);
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }

}
