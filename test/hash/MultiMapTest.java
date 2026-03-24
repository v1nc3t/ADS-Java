package hash;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiMapTest {

    @Test
    void testEverythingOneItem() {
        MultiMap map = new MultiMap();
        map.put(1, 2);
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertEquals(Collections.singletonList(2), map.get(1));
        assertFalse(map.remove(1, 3));
        assertTrue(map.remove(1, 2));
    }
}
