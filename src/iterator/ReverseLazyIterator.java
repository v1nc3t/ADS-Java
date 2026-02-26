package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ReverseLazyIterator<V> implements Iterator<V> {

    private List<V> list;

    private int index;

    public ReverseLazyIterator(List<V> list) {
        this.list = list;
        this.index = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.get(index--);
    }

    @Override
    public void remove() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index--;
    }
}
