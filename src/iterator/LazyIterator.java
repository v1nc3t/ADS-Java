package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LazyIterator<V> implements Iterator<V> {

    private List<V> list;

    private int index = 0;

    public LazyIterator(List<V> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.get(index++);
    }

    @Override
    public void remove() {
        if (!hasNext()) {
            throw new IllegalStateException();
        }
        index--;
    }
}
