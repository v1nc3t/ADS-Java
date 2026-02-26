package queue;

import list.CLList;

public class Deque<T> {

    private final CLList<T> list;

    public Deque() {
        list = new CLList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T getFirst() throws EmptyDequeException {
        if (list.isEmpty()) {
            throw new EmptyDequeException();
        }
        return list.getFirst().getElement();
    }

    public T getLast() throws EmptyDequeException {
        if (list.isEmpty()) {
            throw new EmptyDequeException();
        }
        return list.getLast().getElement();
    }

    public void addFirst(T element) {
        list.addFirst(element);
    }

    public void addLast(T element) {
        list.addLast(element);
    }

    public T removeFirst() throws EmptyDequeException {
        if (list.isEmpty()) {
            throw new EmptyDequeException();
        }
        return list.remove(list.getFirst());
    }

    public T removeLast() throws EmptyDequeException {
        if (list.isEmpty()) {
            throw new EmptyDequeException();
        }
        return list.remove(list.getLast());
    }
}
