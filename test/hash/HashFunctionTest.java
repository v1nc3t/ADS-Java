package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashFunctionTest {

    private static final int DEFAULT_SIZE = 4;

    @Test
    void testETHHashNull() {
        assertEquals(0, HashFunctions.ETHHash(null, DEFAULT_SIZE));
    }

    @Test
    void testGNUCPPHashNull() {
        assertEquals(0, HashFunctions.GNUCPPHash(null, DEFAULT_SIZE));
    }

    @Test
    void testGNUCC1HashNull() {
        assertEquals(0, HashFunctions.GNUCC1Hash(null, DEFAULT_SIZE));
    }

    @Test
    void testHashCodeHashNull() {
        assertEquals(0, HashFunctions.HashCodeHash(null, DEFAULT_SIZE));
    }

    @Test
    void testETHHashHelloWorld() {
        assertEquals(1, HashFunctions.ETHHash("Hello World!", DEFAULT_SIZE));
    }

    @Test
    void testGNUCPPHashHelloWorld() {
        assertEquals(1, HashFunctions.GNUCPPHash("Hello World!", DEFAULT_SIZE));
    }

    @Test
    void testGNUCC1HashHelloWorld() {
        assertEquals(1, HashFunctions.GNUCC1Hash("Hello World!", DEFAULT_SIZE));
    }

    @Test
    void testHashCodeHashHelloWorld() {
        assertEquals(3, HashFunctions.HashCodeHash("Hello World!", DEFAULT_SIZE));
    }
    @Test
    void testETHHashHelloWorld2xSize() {
        assertEquals(5, HashFunctions.ETHHash("Hello World!", DEFAULT_SIZE * 2));
    }

    @Test
    void testGNUCPPHashHelloWorld2xSize() {
        assertEquals(1, HashFunctions.GNUCPPHash("Hello World!", DEFAULT_SIZE * 2));
    }

    @Test
    void testGNUCC1HashHelloWorld2xSize() {
        assertEquals(1, HashFunctions.GNUCC1Hash("Hello World!", DEFAULT_SIZE * 2));
    }

    @Test
    void testHashCodeHashHelloWorld2xSize() {
        assertEquals(3, HashFunctions.HashCodeHash("Hello World!", DEFAULT_SIZE * 2));
    }

}
