package hash;

import java.util.LinkedList;

public class ChainedHashTable {

    protected LinkedList<Entry>[] myTable;

    /**
     * Constructs a new HashTable.
     *
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    public ChainedHashTable(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        myTable = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            myTable[i] = new LinkedList<>();
        }
    }

    public LinkedList<Entry>[] getTable() {
        return myTable;
    }

    /**
     * Gets the capacity of this HashTable.
     *
     * @return the capacity of the HashTable.
     */
    public int getCapacity() {
        return myTable.length;
    }

    /**
     * Add a key value pair to the HashTable.
     *
     * @param key
     *     to identify the value.
     * @param value
     *     that is identified by the key.
     */
    public void put(String key, Integer value) {
        int index = hash(key);

        Entry newEntry = new Entry(key, value);

        myTable[index].remove(newEntry);
        myTable[index].add(newEntry);
    }

    /**
     * @param key
     *     to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {
        int index = hash(key);

        Entry dummy = new Entry(key, null);

        return myTable[index].contains(dummy);
    }

    /**
     * Get a value from the HashTable.
     *
     * @param key
     *     that identifies the value.
     * @return the value associated with the key or `null` if the key is not in the HashTable.
     */
    public Integer get(String key) {
        int index = hash(key);

        for (Entry e : myTable[index]) {
            if (e.equals(key)) {
                return e.value;
            }
        }
        return null;
    }


    /**
     * Hashes a string/key.
     *
     * @param item
     *     to hash.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public int hash(String item) {
        return item == null ? 0 : Math.abs(item.hashCode()) % getCapacity();
    }
}
