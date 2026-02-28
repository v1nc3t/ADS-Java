package queue;

import stack.DynamicStack;

import java.util.NoSuchElementException;

public class StackQueue<T> {

    private DynamicStack<T> stackIn;

    private DynamicStack<T> stackOut;


    public StackQueue() {
        stackIn = new DynamicStack<>();
        stackOut = new DynamicStack<>();
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public int size() {
        return stackIn.size() + stackOut.size();
    }

    public void enqueue(T element) {
        stackIn.push(element);
    }

    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        shiftStacks();
        return stackOut.pop();
    }

    public T first() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        shiftStacks();
        return stackOut.peek();
    }
}
