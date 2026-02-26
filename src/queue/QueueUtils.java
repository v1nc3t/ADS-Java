package queue;

public final class QueueUtils {

    public static <T> void reverse(Queue<T> queue) {
        if (queue.isEmpty()) {
            return;
        }
        T val = queue.dequeue();
        reverse(queue);
        queue.enqueue(val);
    }
}
