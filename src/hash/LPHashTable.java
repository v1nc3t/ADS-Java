package hash;

public class LPHashTable {

    private final Integer[] array;

    public LPHashTable(int capacity) {
        this.array = new Integer[capacity];
    }

    public void add(int e) {
        int i = Math.abs(e) % array.length;

        while (array[i] != null && array[i] != e) {
            i = (i + 1) % array.length;
        }
        array[i] = e;
    }

    public boolean contains(int e) {
        int i = Math.abs(e) % array.length;
        while (array[i] != null) {
            if (array[i] == e) {
                return true;
            }
            i = (i + 1) % array.length;
        }
        return false;
    }

    public void remove(int e) {
        int i = Math.abs(e) % array.length;
        while (array[i] != null) {
            if (array[i] == e) {
                array[i] = null;

                i = (i + 1) % array.length;
                while (array[i] != null) {
                    Integer temp = array[i];
                    array[i] = null;
                    add(temp);
                    i = (i + 1) % array.length;
                }
                return;
            }
            i = (i + 1) % array.length;
        }
    }

}