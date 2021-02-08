package ck.rockman.utils;

import ck.rockman.utils.array.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayUtilsTest {
    @Test
    void testEncodeArrayIndex() {
        int[][] array = new int[4][5];
        assertEquals(1, ArrayUtils.encodePosition(0, 0, array));
        assertEquals(2, ArrayUtils.encodePosition(0, 1, array));
        assertEquals(3, ArrayUtils.encodePosition(0, 2, array));
        assertEquals(4, ArrayUtils.encodePosition(0, 3, array));
        assertEquals(5, ArrayUtils.encodePosition(0, 4, array));
        assertEquals(6, ArrayUtils.encodePosition(1, 0, array));
        assertEquals(7, ArrayUtils.encodePosition(1, 1, array));
        assertEquals(8, ArrayUtils.encodePosition(1, 2, array));
        assertEquals(9, ArrayUtils.encodePosition(1, 3, array));
        assertEquals(10, ArrayUtils.encodePosition(1, 4, array));
        assertEquals(11, ArrayUtils.encodePosition(2, 0, array));
        assertEquals(12, ArrayUtils.encodePosition(2, 1, array));
        assertEquals(13, ArrayUtils.encodePosition(2, 2, array));
        assertEquals(14, ArrayUtils.encodePosition(2, 3, array));
        assertEquals(15, ArrayUtils.encodePosition(2, 4, array));
        assertEquals(16, ArrayUtils.encodePosition(3, 0, array));
        assertEquals(17, ArrayUtils.encodePosition(3, 1, array));
        assertEquals(18, ArrayUtils.encodePosition(3, 2, array));
        assertEquals(19, ArrayUtils.encodePosition(3, 3, array));
        assertEquals(20, ArrayUtils.encodePosition(3, 4, array));
    }

    @Test
    void testDecodeArrayIndex() {
        int[][] array = new int[4][5];
        assertEquals(pos(0, 0), ArrayUtils.decode(1, array));
        assertEquals(pos(0, 1), ArrayUtils.decode(2, array));
        assertEquals(pos(0, 2), ArrayUtils.decode(3, array));
        assertEquals(pos(0, 3), ArrayUtils.decode(4, array));
        assertEquals(pos(0, 4), ArrayUtils.decode(5, array));
        assertEquals(pos(1, 0), ArrayUtils.decode(6, array));
        assertEquals(pos(1, 1), ArrayUtils.decode(7, array));
        assertEquals(pos(1, 2), ArrayUtils.decode(8, array));
        assertEquals(pos(1, 3), ArrayUtils.decode(9, array));
        assertEquals(pos(1, 4), ArrayUtils.decode(10, array));
        assertEquals(pos(2, 0), ArrayUtils.decode(11, array));
        assertEquals(pos(2, 1), ArrayUtils.decode(12, array));
        assertEquals(pos(2, 2), ArrayUtils.decode(13, array));
        assertEquals(pos(2, 3), ArrayUtils.decode(14, array));
        assertEquals(pos(2, 4), ArrayUtils.decode(15, array));
        assertEquals(pos(3, 0), ArrayUtils.decode(16, array));
        assertEquals(pos(3, 1), ArrayUtils.decode(17, array));
        assertEquals(pos(3, 2), ArrayUtils.decode(18, array));
        assertEquals(pos(3, 3), ArrayUtils.decode(19, array));
        assertEquals(pos(3, 4), ArrayUtils.decode(20, array));
    }

    private Position pos(int i, int j) {
        return new Position(i, j);
    }
}