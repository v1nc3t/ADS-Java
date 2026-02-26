package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnapshotIterator<V> implements Iterator<V> {

    private List<V> copy;

    private int index;

    public SnapshotIterator(List<V> copy) {
        this.copy = new ArrayList<>(copy);
    }

    @Override
    public boolean hasNext() {
        return index < copy.size();
    }

    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return copy.get(index++);
    }

    @Override
    public void remove() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index++;
    }
}
