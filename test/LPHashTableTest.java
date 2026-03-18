import hash.LPHashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LPHashTableTest {

    @Test
    void simpleLPHashTableTest() {
        LPHashTable set = new LPHashTable(1);
        set.add(0);
        assertTrue(set.contains(0));
    }
}
