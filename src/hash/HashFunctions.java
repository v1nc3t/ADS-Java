package hash;

public final class HashFunctions {

    public static int ETHHash(String item, int capacity) {
        if (item == null) {
            return 0;
        }
        int b = 1;
        for (char c : item.toCharArray()) {
            b = c * ((b % 257) + 1);
        }
        return b % capacity;
    }

    public static int GNUCPPHash(String item, int capacity) {
        if (item == null) {
            return 0;
        }
        int b = 0;
        for (char c : item.toCharArray()) {
            b = 4 * b + c;
        }
        return (b & 0x7FFFFFFF) % capacity;
    }

    public static int GNUCC1Hash(String item, int capacity) {
        if (item == null) {
            return 0;
        }
        int b = item.length();
        for (char c : item.toCharArray()) {
            b = 613 * b + c;
        }
        return (b & 0x3FFFFFFF) % capacity;
    }

    public static int HashCodeHash(String item, int capacity) {
        if (item == null) {
            return 0;
        }
        return Math.abs(item.hashCode()) % capacity;
    }

}