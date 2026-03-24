package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMap {

    private final Map<Integer, List<Integer>> map;

    /**
     * Creates a new MultiMap.
     */
    public MultiMap() {
        this.map = new HashMap<>();
    }

    /**
     * Gets the size of this MultiMap.
     *
     * @return The number of (key, value) pairs in the MultiMap.
     */
    public int size() {
        int size = 0;
        for (List<Integer> list : map.values()) {
            size += list.size();
        }
        return size;
    }

    /**
     * Gets whether this MultiMap is empty.
     *
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     *
     * @param key Key for the new item.
     * @param value New item to add to the MultiMap.
     */
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    /**
     * Returns all values in the MultiMap for the given key.
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     *         If the key is not in the map, return an empty list.
     */
    public List<Integer> get(int key) {
        if (!map.containsKey(key)) {
            return new ArrayList<>();
        }
        return map.get(key);
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     */
    public boolean remove(int key, int value) {
        List<Integer> list = map.get(key);
        if (list != null && list.remove(Integer.valueOf(value))) {
            if (list.isEmpty()) {
                map.remove(key);
            }
            return true;
        }
        return false;
    }
}
