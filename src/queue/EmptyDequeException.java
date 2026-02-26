package queue;

public class EmptyDequeException extends Exception {

    public EmptyDequeException() {
        super("Deque is empty");
    }

    public EmptyDequeException(String msg) {
        super(msg);
    }
}